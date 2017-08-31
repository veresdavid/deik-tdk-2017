package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;

import exceptions.CompilationException;
import exceptions.InvalidVariableException;
import exceptions.OperatorInitializationException;
import exceptions.OperatorNotFoundException;
import exceptions.SolutionSearcherNotFoundException;
import exceptions.StateInitializationException;
import exceptions.StateNotFoundException;
import exceptions.TypeMismatchException;
import exceptions.WrongFileExtensionException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import solutionsearchers.A;
import solutionsearchers.BackTrackCircle;
import solutionsearchers.BackTrackOptimal;
import solutionsearchers.BackTrackPathLengthLimitation;
import solutionsearchers.BackTrackSimple;
import solutionsearchers.BestFirst;
import solutionsearchers.BreadthFirst;
import solutionsearchers.DepthFirst;
import solutionsearchers.Optimal;
import solutionsearchers.SolutionSearcher;
import solutionsearchers.helpers.ExtendedInformationCollector;

public class SolutionManager{
	private List<OperatorInterface> operators;
	private StateInterface state;
	
	public SolutionManager(Class<?> stateClass, List<Class<?>> operatorClasses) throws StateInitializationException, OperatorInitializationException{
		OperatorInstantiator operatorInstantiator = new OperatorInstantiator();
		operators = operatorInstantiator.getOperatorInstances(operatorClasses);
		try {
			state = (StateInterface) stateClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new StateInitializationException(e);
		}
	}
	
	public String doBackTrackSimple(boolean doTree){
		BackTrackSimple backTrackSimple = new BackTrackSimple(state);
		
		backTrackSimple.setOperators(operators);
		
		if(doTree){
			backTrackSimple.setInformationCollector(new ExtendedInformationCollector());
		
		}
		
		backTrackSimple.search();
		return backTrackSimple.searchFinished();
	}
	
	public String doBackTrackCircle(boolean doTree) {
		BackTrackCircle backTrackCircle = new BackTrackCircle(state);
		
		backTrackCircle.setOperators(operators);
		
		if(doTree){
			backTrackCircle.setInformationCollector(new ExtendedInformationCollector());
		}
		
		backTrackCircle.search();
		return backTrackCircle.searchFinished();
	}

	public String doBackTrackPathLengthLimitation(boolean doTree, int backTrackPathLengthLimitationLimit) {
		BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(state, backTrackPathLengthLimitationLimit);
		
		backTrackPathLengthLimitation.setOperators(operators);
		
		if(doTree){
			backTrackPathLengthLimitation.setInformationCollector(new ExtendedInformationCollector());
		}
		
		backTrackPathLengthLimitation.search();
		return backTrackPathLengthLimitation.searchFinished();
	}

	public String doBackTrackOptimal(boolean doTree, int backTrackOptimalLimit) {
		BackTrackOptimal backTrackOptimal = new BackTrackOptimal(state, backTrackOptimalLimit);
		
		backTrackOptimal.setOperators(operators);
		
		if(doTree){
			backTrackOptimal.setInformationCollector(new ExtendedInformationCollector());
		} 
		
		backTrackOptimal.search();
		return backTrackOptimal.searchFinished();
	}

	public String doBreadthFirst(boolean doTree) {
		BreadthFirst breadthFirst = new BreadthFirst(state);
		
		breadthFirst.setOperators(operators);
		
		if(doTree){
			breadthFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		breadthFirst.search();
		return breadthFirst.searchFinished();
	}

	public String doDepthFirst(boolean doTree) {
		DepthFirst depthFirst = new DepthFirst(state);
		
		depthFirst.setOperators(operators);
		
		if(doTree){
			depthFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		depthFirst.search();
		return depthFirst.searchFinished();
	}

	public String doOptimal(boolean doTree) {
		Optimal optimal = new Optimal(state);
		
		optimal.setOperators(operators);
		
		if(doTree){
			optimal.setInformationCollector(new ExtendedInformationCollector());
		}
		
		optimal.search();
		return optimal.searchFinished();
	}
	
	
	public String doBestFirst(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		BestFirst bestFirst = new BestFirst(state, heuristicFunction, variablesInHeuristicFunction);
		
		bestFirst.setOperators(operators);
		
		if(doTree){
			bestFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		bestFirst.search();
		return bestFirst.searchFinished();
	}
	
	public String doA(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException {
		A a = new A(state, heuristicFunction, variablesInHeuristicFunction);
		
		a.setOperators(operators);
		
		if(doTree){
			a.setInformationCollector(new ExtendedInformationCollector());
		}
		
		a.search();
		return a.searchFinished();
	}
	
	private URL userSolutionSearcherClassesFolderURL;
	private List<String> allJavaFileLocations;
	private List<File> loadableClasses;
	private Class<?> solutionSearcherClass;
	
	public String doUserSolutionSearcher(List<String> javaFileLocations, List<String> javaCodes, boolean doHeuristic, String heuristicFunction, Set<String> variablesInHeuristicFunction, Object[] variables, boolean doTree) throws Exception{
		File solutionSearcherFilesFolder = new File("solutionSearcherFiles");
		
		if(!solutionSearcherFilesFolder.exists())
			solutionSearcherFilesFolder.mkdirs();
		
		allJavaFileLocations = new ArrayList<>();
		
		for(String javaCode : javaCodes) {
			File javaFile = new File("solutionSearcherFiles/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd-hh-mm-ss")) + UUID.randomUUID().toString() + ".java");
			javaFile.createNewFile();
			
			BufferedWriter writer = null;
			
			try {
				writer = new BufferedWriter(new FileWriter(javaFile.getAbsolutePath()));
				writer.write(javaCode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			allJavaFileLocations.add(javaFile.getAbsolutePath());
		}
		
		for(String javaFileLocation : javaFileLocations) {
			if(!FilenameUtils.isExtension(javaFileLocation, "java")) {
				throw new WrongFileExtensionException();
			}
			
			allJavaFileLocations.add(javaFileLocation);
		}
		
		File userSolutionSearcherClassesFolder = new File("userSolutionSearcherClasses" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd-hh-mm-ss")) + UUID.randomUUID().toString());
		userSolutionSearcherClassesFolder.mkdir();
		
		userSolutionSearcherClassesFolderURL = userSolutionSearcherClassesFolder.toURI().toURL();
		
		compileFiles();
		
		loadableClasses = new ArrayList<>();
		
		getLoadableClassesInFolder(userSolutionSearcherClassesFolder);
		
		loadClasses(userSolutionSearcherClassesFolder);
				
		try {
			
			// TODO van-e olyan módszer amivel nem kell megszabnom a sorrendet a konstruktor paramétereinél
				// lekérni minden konstruktorát, megkeresni azokat amiknek a paraméterek száma megfelelő
				// azok közül kiválasztani a megfelelőt
				// belepakolni tömbbe megfelelő sorrendben a változókat
				// létrehozni a tömmbel egy egyedet
			
			Constructor[] allConstructors = solutionSearcherClass.getDeclaredConstructors();
			
			SolutionSearcher solutionSearcher = null;
			if(!doHeuristic && variables.length == 0) {
				solutionSearcher = (SolutionSearcher) solutionSearcherClass.getConstructor(StateInterface.class).newInstance(state);
			} else if(doHeuristic && variables.length == 0) {
				/*for (Constructor ctor : allConstructors) {
					Class<?>[] pType  = ctor.getParameterTypes();
					if(pType.length == 3) {
						checkForType(pType, StateInterface.class);
						checkForType(pType, String.class);
						checkForType(pType, Set.class);
					}
				}*/
				solutionSearcher = (SolutionSearcher) solutionSearcherClass.getConstructor(StateInterface.class, String.class, Set.class).newInstance(state, heuristicFunction, variablesInHeuristicFunction);
			} else if(!doHeuristic && variables.length != 0) {
				Object[] tmp = {state};
				Object[] params = ArrayUtils.addAll(tmp, variables);
				for (Constructor ctor : allConstructors) {
					Class<?>[] pType  = ctor.getParameterTypes();
					if(pType.length == params.length) {
						solutionSearcher = (SolutionSearcher) ctor.newInstance(params);
					}
				}
			} else if(doHeuristic && variables.length != 0) {
				Object[] tmp = {state, heuristicFunction, variablesInHeuristicFunction};
				Object[] params = ArrayUtils.addAll(tmp, variables);
				for (Constructor ctor : allConstructors) {
					Class<?>[] pType  = ctor.getParameterTypes();
					if(pType.length == params.length) {
						solutionSearcher = (SolutionSearcher) ctor.newInstance(params);
					}
				}
			}
			
			solutionSearcher.setOperators(operators);
			
			if(doTree){
				solutionSearcher.setInformationCollector(new ExtendedInformationCollector());
			}
			solutionSearcher.search();
			return solutionSearcher.searchFinished();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO ez okés?
		return null;
	}
	
	private void compileFiles() throws CompilationException, IOException, URISyntaxException{
		List<String> processBuilderArgList = new ArrayList<>(Arrays.asList("javac", "-d", userSolutionSearcherClassesFolderURL.getPath(), "-nowarn", "-cp", getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
		processBuilderArgList.addAll(allJavaFileLocations);
		
		ProcessBuilder processBuilder = new ProcessBuilder(processBuilderArgList);
		Process process = processBuilder.start();
		while(process.isAlive());
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
		StringBuilder compilationError = new StringBuilder();
		String line = null;
		while((line = errorReader.readLine()) != null){
			compilationError.append(line);
		}
		
		if(!compilationError.toString().isEmpty()){
			throw new CompilationException(compilationError.toString());
		}
	}
	
	private void getLoadableClassesInFolder(File folder){
		if(folder.isDirectory()){
			for(File file : folder.listFiles()){
				getLoadableClassesInFolder(file);
			}
			for (File classFile : folder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".class");
				}
			})) {
				loadableClasses.add(classFile);
			}
		}
	}
	
	private void loadClasses(File userSolutionSearcherClassesFolder) throws ClassNotFoundException, IOException, StateNotFoundException, OperatorNotFoundException, SolutionSearcherNotFoundException{
		boolean isSolutionSearcherFound = false;
		URLClassLoader loader = new URLClassLoader(new URL[] { userSolutionSearcherClassesFolderURL }, getClass().getClassLoader());;
		
		for (File classFile : loadableClasses) {
			String classNameAndPackage = classFile.getAbsolutePath()
					.replace(userSolutionSearcherClassesFolder.getAbsolutePath() + "\\", "").replace("\\", ".");

			classNameAndPackage = classNameAndPackage.substring(0, classNameAndPackage.length() - 6);
			try {
				Method method = loader.getClass().getDeclaredMethod("addURL", URL.class);
				method.setAccessible(true);
				method.invoke(loader, userSolutionSearcherClassesFolderURL);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			Class<?> cls = loader.loadClass(classNameAndPackage);
			if (SolutionSearcher.class.isAssignableFrom(cls) && !SolutionSearcher.class.equals(cls)) {
				solutionSearcherClass = cls;
				isSolutionSearcherFound = true;
			}
		}
		
		if(!isSolutionSearcherFound){
			throw new SolutionSearcherNotFoundException();
		}
	}
	
	/*private int checkForType(Class<?>[] pType, Object obj) {
		for (int i = 0; i < pType.length; i++) {
		    if()
		}
	}*/
}