package nodes.heuristicparser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nfunk.jep.JEP;

import nodes.Node;

public class HeuristicParser {
	
	private String expression;
	private Set<String> variables;
	private Map<String, Double> variableNamesAndValues;
	private Node node;
	private List<Field> fieldsOfNode;
	
	public HeuristicParser(String heuristic, Set<String> variables, Node node) {
		this.expression = heuristic;
		this.variables = variables;
		variableNamesAndValues = new HashMap<>();
		this.node = node;
		fieldsOfNode = getFieldsOfNode(this.node);
	}
	
	public List<Field> getFieldsOfNode(Node node){
		List<Field> fields = new ArrayList<>(Arrays.asList(node.getClass().getDeclaredFields()));
		
		Class superClass = node.getClass().getSuperclass();
		while(nodes.Node.class.isAssignableFrom(superClass)){
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
			superClass = superClass.getSuperclass();
		}
		
		return fields;
	}
	
	public double Parse(){
		
		for(String variable : variables){
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
		
		System.out.println(expression + " " + variableNamesAndValues);
		
		JEP myParser = new JEP();
	    myParser.addStandardFunctions();
	    myParser.addStandardConstants();
		for(String key : variableNamesAndValues.keySet()){
	    	System.out.println(key + " " + variableNamesAndValues.get(key));
	    	myParser.addVariable(key, variableNamesAndValues.get(key));
	    }
		myParser.parseExpression(expression);
		return myParser.getValue();
		//return 1;
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
	
	private Object getVariable(String packageName, String className, String fieldName, String fieldNameListElement, List<String> innerFields, List<String> innerFieldsListElement) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		Class classByName = Class.forName(packageName + "." + className);
		
		boolean isClassByNameContainsField = false;
		
		for(Field field : Arrays.asList(classByName.getDeclaredFields())){
			if(field.getName() == fieldName){
				isClassByNameContainsField = true;
			}
		}
		
		if(!isClassByNameContainsField){
			classByName = classByName.getSuperclass();
		}
		
		Field fieldByName = classByName.getDeclaredField(fieldName);
		fieldByName.setAccessible(true);
		Object object = null;
		if(nodes.Node.class.isAssignableFrom(classByName))
		{
			object = fieldByName.get(node);
		} else {
			object = fieldByName.get(classByName.newInstance());
		}
		

		if(!fieldNameListElement.isEmpty()){
			if(java.util.List.class.isAssignableFrom(object.getClass())){
				List<Integer> elementList = processListElement(fieldNameListElement);
				for(int element : elementList){
					object = ((List<?>)object).get(element);
				}
			} else {
				System.out.println("nem nyert");
			}
		}
		
		for(String innerField : innerFields){
			Class innerClass = object.getClass();
			
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
			//System.out.println(innerClass);
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

	private List<Object> processVariableName(String variableName){
		List<Object> processedValues = new ArrayList<>();
		
		int pointPosition = variableName.indexOf(".");
		String packageName = variableName.substring(0, pointPosition);
		variableName = variableName.substring(pointPosition + 1);
		
		pointPosition = variableName.indexOf(".");
		String className = variableName.substring(0, pointPosition);
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
		
		//System.out.println(packageName + " " + className + " " + fieldName + " " + fieldNameListElement + " " + innerFields + " " + innerFieldsListElement) ;
		Object object = null;
		try {
			object = getVariable(packageName, className, fieldName, fieldNameListElement, innerFields, innerFieldsListElement);
			//System.out.println(object);
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Set.class.isAssignableFrom(object.getClass())){
			Set<?> set = (Set)object;
			for(Object setElement : set){
				processedValues.add(setElement);
			}
		} else {
			processedValues.add(object);
		}
		
		return processedValues;
	}
}
