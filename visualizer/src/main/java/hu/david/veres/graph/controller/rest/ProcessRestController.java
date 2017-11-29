package hu.david.veres.graph.controller.rest;

import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.form.CustomSearchAlgorithmData;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.form.VariableData;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.service.UserService;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import main.SolutionMaker;
import main.SolutionManager;
import misc.ClassManager;
import misc.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ProcessRestController {

	@Autowired
	private ProcessService processService;

	@Autowired
	private UserService userService;

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private StorageService storageService;

	@Value("${file.generated.folder}")
	private String generatedFolderName;

	@RequestMapping(path = "/accept/{processId}")
	public boolean acceptProcess(@PathVariable("processId") String processId) {

		if (!isUserLoggedIn()) {
			return false;
		}

		UserDTO userDTO = userService.getUserByUsername(activeUsersUsername());

		if (!userDTO.getRole().equals("admin")) {
			return false;
		}

		ProcessDTO processDTO = processService.getProcessByIdentifier(processId);

		if (processDTO == null) {
			return false;
		}

		// SML
		StateGenerator stateGenerator = new StateGenerator();
		OperatorGenerator operatorGenerator = new OperatorGenerator();
		InputReader inputReader = new InputReader();
		ProjectRepresentation projectRepresentation;

		// Store state-space description to a file
		File stateSpaceFile = null;
		try {
			stateSpaceFile = storageService.getStateSpaceFile(processDTO.getStateSpaceFileName());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Process the file
		try {
			projectRepresentation = inputReader.processInputFile(stateSpaceFile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Generate .java files to a folder with generated package name
		ProjectGenerator projectGenerator = new ProjectGenerator(projectRepresentation);
		List<ClassRepresentation> classRepresentations;
		String packageName = ProcessUtils.generatePackageName();
		try {
			classRepresentations = projectGenerator.generate(generatedFolderName, packageName, true);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Object wrapping the created .java files information
		ClassManager classManager = new ClassManager();
		classManager.addClasses(classRepresentations);

		// SOLUTION MANAGER
		SolutionManager solutionManager;
		try {

			SolutionMaker solutionMaker = new SolutionMaker(classManager.getFilePaths());
			classManager.clear();
			solutionManager = solutionMaker.start();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
		processThread.setProcessIdentifier(processDTO.getProcessIdentifier());
		processThread.setSolutionManager(solutionManager);
		ProblemForm problemForm = new ProblemForm();
		CustomSearchAlgorithmData customSearchAlgorithmData = new CustomSearchAlgorithmData();
		customSearchAlgorithmData.setFiles(Arrays.asList(processDTO.getCustomFiles().split(";")));
		customSearchAlgorithmData.setUsesHeuristic(processDTO.isUsesHeuristic());
		customSearchAlgorithmData.setVariables(getVariableDataAsList(processDTO.getVariableData()));
		problemForm.setCustomSearchAlgorithms(Arrays.asList(customSearchAlgorithmData));
		problemForm.setHeuristic(processDTO.getHeuristic());
		problemForm.setVariablesInHeuristicFunction(processDTO.getVariablesInHeuristicFunction());
		processThread.setProblemForm(problemForm);
		processThread.setAlgorithmIndex(0);
		processThread.setCustom(true);
		threadPoolTaskExecutor.execute(processThread);

		processDTO.setStatus("accepted");
		processService.save(processDTO);

		return true;

	}

	@RequestMapping(path = "/reject/{processId}")
	public boolean rejectProcess(@PathVariable("processId") String processId) {

		if (!isUserLoggedIn()) {
			return false;
		}

		UserDTO userDTO = userService.getUserByUsername(activeUsersUsername());

		if (!userDTO.getRole().equals("admin")) {
			return false;
		}

		ProcessDTO processDTO = processService.getProcessByIdentifier(processId);

		if (processDTO == null) {
			return false;
		}

		processDTO.setStatus("rejected");
		processDTO.setDone(true);

		processService.save(processDTO);

		return true;

	}

	private boolean isUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return true;
		}

		return false;

	}

	private String activeUsersUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	private List<VariableData> getVariableDataAsList(String variableData) {

		if (variableData == null || variableData.isEmpty()) {
			return Collections.emptyList();
		}

		List<VariableData> variableDataList = new ArrayList<>();

		String[] parts = variableData.split(";");

		for (String part : parts) {

			String[] subParts = part.split(":");

			variableDataList.add(new VariableData(subParts[0], subParts[1]));

		}

		return variableDataList;

	}

}
