package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import exceptions.OperatorInitializationException;
import interfaces.OperatorInterface;

@SuppressWarnings("unchecked")
public class OperatorInstantiator{
	
  public List<OperatorInterface> getOperatorInstances(List<Class<?>> operatorClasses) throws OperatorInitializationException {
    List<OperatorInterface> result = new ArrayList<>();

	for(Class<?> operatorClass : operatorClasses){
		try {
			result.addAll((List<OperatorInterface>)operatorClass.getMethod("initOperators").invoke(operatorClass.newInstance()));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException e) {
			throw new OperatorInitializationException(e);
		}
	}
    return result;
  }
}