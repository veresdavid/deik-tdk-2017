package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import exceptions.CompilationException;
import exceptions.OperatorInitializationException;
import exceptions.OperatorNotFoundException;
import exceptions.StateInitializationException;
import exceptions.StateNotFoundException;
import exceptions.TemporaryFolderCreationException;
import exceptions.TemporaryFolderDeletionException;
import exceptions.WrongFileExtensionException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class SolutionMaker {
	
	private List<String> filePaths;
	//private UserInput userInput;
	private File classDestinationFile;
	private URL classDestinationURL;
	private List<File> loadableClasses;
	private Class<?> stateClass;
	private List<Class<?>> operatorClasses;
	
	private static URLClassLoader loader;
	
	public SolutionMaker(List<String> filePaths) throws TemporaryFolderCreationException, MalformedURLException{
		this.filePaths = filePaths;
		classDestinationFile = new File("externalClasses/" + UUID.randomUUID().toString() + "/");
		makeTemporaryFolderForClasses();
		classDestinationURL = classDestinationFile.toURI().toURL();
		loadableClasses = new ArrayList<>();
		operatorClasses = new ArrayList<>();
		if(loader == null){
			loader  = new URLClassLoader(new URL[] { classDestinationURL }, getClass().getClassLoader());
		}
	}
	
	public SolutionManager start() throws WrongFileExtensionException, CompilationException, IOException, ClassNotFoundException, StateNotFoundException, OperatorNotFoundException, StateInitializationException, OperatorInitializationException, TemporaryFolderDeletionException, URISyntaxException{
		validateFilePaths();
		compileFiles();
		getLoadableClassesInFolder(classDestinationFile);
		loadClasses();
		if(!deleteFolder(classDestinationFile)){
			throw new TemporaryFolderDeletionException("Could not delete this folder: " + classDestinationFile.getAbsolutePath());
		}
		return new SolutionManager(stateClass, operatorClasses);
	}
	
	private void validateFilePaths() throws WrongFileExtensionException{
		for(String filePath : filePaths){
			if(!FilenameUtils.isExtension(filePath, "java")){
				throw new WrongFileExtensionException();
			}
		}
	}
	
	private void makeTemporaryFolderForClasses() throws TemporaryFolderCreationException{
		try{
			if(!classDestinationFile.exists()){
				classDestinationFile.mkdirs();
			}
		} catch (Exception e){
			throw new TemporaryFolderCreationException(e);
		}
	}
	
	private void compileFiles() throws CompilationException, IOException, URISyntaxException{
		List<String> processBuilderArgList = new ArrayList<>(Arrays.asList("javac", "-d", classDestinationURL.getPath(), "-nowarn", "-cp", getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
		processBuilderArgList.addAll(filePaths);
		
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
	
	private void loadClasses() throws ClassNotFoundException, IOException, StateNotFoundException, OperatorNotFoundException{
		boolean isStateClassFound = false;
		boolean isOperatorClassFound = false;
		
		for (File classFile : loadableClasses) {
			String classNameAndPackage = classFile.getAbsolutePath()
					.replace(classDestinationFile.getAbsolutePath() + "\\", "").replace("\\", ".");

			classNameAndPackage = classNameAndPackage.substring(0, classNameAndPackage.length() - 6);
			try {
				Method method = loader.getClass().getDeclaredMethod("addURL", URL.class);
				method.setAccessible(true);
				method.invoke(loader, classDestinationURL);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			Class<?> cls = loader.loadClass(classNameAndPackage);
			if (StateInterface.class.isAssignableFrom(cls) && !StateInterface.class.equals(cls)) {
				stateClass = cls;
				isStateClassFound = true;
			} else if (OperatorInterface.class.isAssignableFrom(cls) && !OperatorInterface.class.equals(cls)) {
				operatorClasses.add(cls);
				isOperatorClassFound = true;
			}
		}
		
		if(!isStateClassFound){
			throw new StateNotFoundException();
		} else if(!isOperatorClassFound){
			throw new OperatorNotFoundException();
		}
	}
	
	public static boolean deleteFolder(File file) {
		if (file.isDirectory()) {
			for (File childOfFile : file.listFiles()) {
				deleteFolder(childOfFile);
			}
		}
		return file.delete();
	}
}
