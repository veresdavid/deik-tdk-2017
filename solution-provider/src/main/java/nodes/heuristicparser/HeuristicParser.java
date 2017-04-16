package nodes.heuristicparser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nfunk.jep.JEP;

import exceptions.InvalidVariableException;
import exceptions.TypeMismatchException;
import nodes.Node;

public class HeuristicParser {
	
	private String expression;
	private Set<String> variables;
	private Map<String, Double> variableNamesAndValues;
	private Node node;
	
	public HeuristicParser(String heuristic, Set<String> variables, Node node) {
		this.expression = heuristic;
		this.variables = variables;
		variableNamesAndValues = new HashMap<>();
		this.node = node;
	}
	
	public List<Field> getFieldsOfNode(Node node){
		List<Field> fields = new ArrayList<>(Arrays.asList(node.getClass().getDeclaredFields()));
		
		Class<?> superClass = node.getClass().getSuperclass();
		while(nodes.Node.class.isAssignableFrom(superClass)){
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
			superClass = superClass.getSuperclass();
		}
		
		return fields;
	}
	
	public double Parse() throws InvalidVariableException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, TypeMismatchException{
		for(String variable : variables){
			if(!variable.startsWith("Node.")){
				throw new InvalidVariableException("Invalid variable name: " + variable);
			}
			String variableWithOutBrackets = removeBrackets(variable);
			variableWithOutBrackets = variableWithOutBrackets.replace(".", "");
			
			List<Object> processedValues = processVariableName(variable);
			List<String> newVariableNames = new ArrayList<>();
			
			for(int i = 0; i < processedValues.size(); i++){
				variableNamesAndValues.put(variableWithOutBrackets + i, ((Number)processedValues.get(i)).doubleValue());
				newVariableNames.add(variableWithOutBrackets + i);
			}
			String newVariableNamesWithComma = "";
			for (int i = 0; i < newVariableNames.size(); i++) {
				if (i == newVariableNames.size() - 1) {
					newVariableNamesWithComma += newVariableNames.get(i);
				} else {
					newVariableNamesWithComma += newVariableNames.get(i) + " , ";
				}
			}
			
			expression = expression.replace(variable, newVariableNamesWithComma);
		}
		
		JEP myParser = new JEP();
	    myParser.addStandardFunctions();
	    myParser.addStandardConstants();
	    myParser.addFunction("min", new Min());
	    myParser.addFunction("max", new Max());
	    myParser.addFunction("avg", new Avg());
		for(String key : variableNamesAndValues.keySet()){
	    	myParser.addVariable(key, variableNamesAndValues.get(key));
	    }
		myParser.parseExpression(expression);
		return myParser.getValue();
	}
	
	private String removeBrackets(String string){
		int bracketPosition = string.indexOf("[");
		while(bracketPosition != -1){
			string = string.substring(0, bracketPosition) + string.substring(string.indexOf("]") + 1);
			bracketPosition = string.indexOf("[");
		}
		
		return string;
	}
	
	private List<Integer> processListElement(String listElement){
		List<Integer> elementList = new ArrayList<>();
		while(!listElement.isEmpty()){
			int endOfElement = listElement.indexOf("]");
			elementList.add(Integer.valueOf(listElement.substring(1, endOfElement)));
			listElement = listElement.substring(endOfElement + 1);
		}
		return elementList;
	}
	
	private Object getVariable(String fieldName, String fieldNameListElement, List<String> innerFields, List<String> innerFieldsListElement) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, TypeMismatchException{
		Class<?> nodeClass = node.getClass();
		
		/*Check if the actual node contains the field or the superclass*/
		boolean isClassByNameContainsField = false;
		for(Field field : Arrays.asList(nodeClass.getDeclaredFields())){
			if(field.getName() == fieldName){
				isClassByNameContainsField = true;
			}
		}
		
		if(!isClassByNameContainsField){
			nodeClass = nodeClass.getSuperclass();
		}
		
		Field fieldByName = nodeClass.getDeclaredField(fieldName);
		fieldByName.setAccessible(true);
		Object object = fieldByName.get(node);

		if(!fieldNameListElement.isEmpty()){
			if(java.util.List.class.isAssignableFrom(object.getClass())){
				List<Integer> elementList = processListElement(fieldNameListElement);
				for(int element : elementList){
					object = ((List<?>)object).get(element);
				}
			} else {
				throw new TypeMismatchException(fieldName + " is not type of List.");
			}
		}
		
		for(String innerField : innerFields){
			Class<?> innerClass = object.getClass();
			
			List<Field> fields = Arrays.asList(innerClass.getDeclaredFields());
			boolean isCointains = false;
			for(Field field : fields){
				if(field.getName().equals(innerField)){
					isCointains = true;
				}
			}
			
			if(!isCointains){
				innerClass = innerClass.getSuperclass();
			}
			fieldByName = innerClass.getDeclaredField(innerField);
			fieldByName.setAccessible(true);
			object = fieldByName.get(object);
			
			String actualElement = innerFieldsListElement.get(innerFields.indexOf(innerField));
			
			if(!actualElement.isEmpty()){
				if(java.util.List.class.isAssignableFrom(object.getClass())){
					List<Integer> elementList = processListElement(actualElement);
					for(int element : elementList){
						object = ((List<?>)object).get(element);
					}
				} else {
					System.out.println("nem nyert");
				}
			}			
		}
		
		return object;
	}

	// Csak a Node-dal kezdődőeket fogadjuk el.
		// igy nem kell package név, mindig a Node-ot használjuk.
	
	private List<Object> processVariableName(String variableName) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, TypeMismatchException{
		List<Object> processedValues = new ArrayList<>();
		System.out.println(variableName);
		int pointPosition = variableName.indexOf(".");
		System.out.println(pointPosition);
		
		pointPosition = variableName.indexOf(".");
		variableName = variableName.substring(pointPosition + 1);
		
		pointPosition = variableName.indexOf(".");
		String fieldName = null;
		if(pointPosition == -1){
			fieldName = variableName;
			variableName = "";
		} else {
			fieldName = variableName.substring(0, pointPosition);
			variableName = variableName.substring(pointPosition + 1);
		}
		
		String fieldNameListElement = "";
		int bracketPosition = fieldName.indexOf("[");
		if(bracketPosition != -1){
			fieldNameListElement = fieldName.substring(bracketPosition);
			fieldName = fieldName.substring(0, bracketPosition);
		}
		
		List<String> innerFields = new ArrayList<>();
		List<String> innerFieldsListElement = new ArrayList<>();
		while(!variableName.equals("")){
			pointPosition = variableName.indexOf(".");
			if(pointPosition == -1){
				innerFields.add(variableName);
				variableName = "";
			} else {
				innerFields.add(variableName.substring(0, pointPosition));
				variableName = variableName.substring(pointPosition + 1);
			}
			
			int lastInnerFieldPosition = innerFields.size() - 1;
			String lastInnerField = innerFields.get(lastInnerFieldPosition);
			
			String innerFieldNameListElement = "";
			bracketPosition = lastInnerField.indexOf("[");
			if(bracketPosition != -1){
				innerFieldNameListElement = lastInnerField.substring(bracketPosition);
				innerFields.set(lastInnerFieldPosition, lastInnerField.substring(0, bracketPosition));
			}
			innerFieldsListElement.add(innerFieldNameListElement);
		}
		
		Object object = getVariable(fieldName, fieldNameListElement, innerFields, innerFieldsListElement);
		
		if(Set.class.isAssignableFrom(object.getClass())){
			Set<?> set = (Set<?>)object;
			for(Object setElement : set){
				processedValues.add(setElement);
			}
		} else if(List.class.isAssignableFrom(object.getClass())){
			List<?> list = (List<?>)object;
			if(List.class.isAssignableFrom(list.get(0).getClass())){
				for(Object listInList : list){
					for(Object listElement : (List<?>)listInList){
						processedValues.add(listElement);
					}
				}
			} else {
				for(Object listElement : list){
					processedValues.add(listElement);
				}
			}
		} else {
			processedValues.add(object);
		}
		
		return processedValues;
	}
}
