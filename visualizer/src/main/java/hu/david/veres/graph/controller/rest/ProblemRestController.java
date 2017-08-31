package hu.david.veres.graph.controller.rest;

import exceptions.*;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.response.ProblemResponse;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.service.UserService;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import hu.david.veres.graph.validator.ProblemFormValidator;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.*;

@RestController
public class ProblemRestController {

	private static final String ERROR_KEY_STATE_SPACE = "stateSpace";
	private static final String ERROR_KEY_SERVER_SIDE = "serverSide";
	private static final String ERROR_MESSAGE_SERVER_SIDE = "Server-side error! Please try again or come back later!";

	private static final String ALGORITHM_NAME_BACKTRACK_SIMPLE = "BackTrackSimple";
	private static final String ALGORITHM_NAME_BACKTRACK_CIRCLE = "BackTrackCircle";
	private static final String ALGORITHM_NAME_BACKTRACK_PATH_LENGTH_LIMIT = "BackTrackPathLengthLimitation";
	private static final String ALGORITHM_NAME_BACKTRACK_OPTIMAL = "BackTrackOptimal";
	private static final String ALGORITHM_NAME_BREADTH_FIRST = "BreadthFirst";
	private static final String ALGORITHM_NAME_DEPTH_FIRST = "DepthFirst";
	private static final String ALGORITHM_NAME_OPTIMAL = "Optimal";
	private static final String ALGORITHM_NAME_BEST_FIRST = "BestFirst";
	private static final String ALGORITHM_NAME_A = "A";

	private static final String ALGORITHM_CODE_BACKTRACK_SIMPLE = "problem_algorithm_backtrack_simple";
	private static final String ALGORITHM_CODE_BACKTRACK_CIRCLE = "problem_algorithm_backtrack_circle";
	private static final String ALGORITHM_CODE_BACKTRACK_PATH_LENGTH_LIMIT = "problem_algorithm_backtrack_path_length_limit";
	private static final String ALGORITHM_CODE_BACKTRACK_OPTIMAL = "problem_algorithm_backtrack_optimal";
	private static final String ALGORITHM_CODE_BREADTH_FIRST = "problem_algorithm_breadth_first";
	private static final String ALGORITHM_CODE_DEPTH_FIRST = "problem_algorithm_depth_first";
	private static final String ALGORITHM_CODE_OPTIMAL = "problem_algorithm_optimal";
	private static final String ALGORITHM_CODE_BEST_FIRST = "problem_algorithm_best_first";
	private static final String ALGORITHM_CODE_A = "problem_algorithm_a";
	private static final String ALGORITHM_CODE_DEFAULT = "problem_algorithm_default";

	private static final String ALGORITHM_CODE_2_BACKTRACK_SIMPLE = "problem.algorithm.backtrack.simple";
	private static final String ALGORITHM_CODE_2_BACKTRACK_CIRCLE = "problem.algorithm.backtrack.circle";
	private static final String ALGORITHM_CODE_2_BACKTRACK_PATH_LENGTH_LIMIT = "problem.algorithm.backtrack.path.length.limit";
	private static final String ALGORITHM_CODE_2_BACKTRACK_OPTIMAL = "problem.algorithm.backtrack.optimal";
	private static final String ALGORITHM_CODE_2_BREADTH_FIRST = "problem.algorithm.breadth.first";
	private static final String ALGORITHM_CODE_2_DEPTH_FIRST = "problem.algorithm.depth.first";
	private static final String ALGORITHM_CODE_2_OPTIMAL = "problem.algorithm.optimal";
	private static final String ALGORITHM_CODE_2_BEST_FIRST = "problem.algorithm.best.first";
	private static final String ALGORITHM_CODE_2_A = "problem.algorithm.a";

	@Value("${file.generated.folder}")
	private String generatedFolderName;

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

	@Autowired
	private ProblemFormValidator problemFormValidator;

	@RequestMapping(path = "/problem", method = RequestMethod.POST)
	public ProblemResponse newProblem(@RequestBody ProblemForm problemForm, BindingResult bindingResult) {

		// AUTHENTICATION CHECK
		if (!isUserLoggedIn()) {
			return problemResponseWithSingleError("authentication", "You are not authenticated! Please log in!");
		}

		// FORM VALIDATION
		problemFormValidator.validate(problemForm, bindingResult);

		if (bindingResult.hasErrors()) {

			ProblemResponse problemResponse = new ProblemResponse();

			problemResponse.setError(true);

			Map<String, String> errors = new HashMap<>();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getCode());
			}
			problemResponse.setErrors(errors);

			return problemResponse;

		}

		// SML

		// Objects for Java file generation
		StateGenerator stateGenerator = new StateGenerator();
		OperatorGenerator operatorGenerator = new OperatorGenerator();
		InputReader inputReader = new InputReader();
		ProjectRepresentation projectRepresentation;

		// Store state-space description to a file
		File stateSpaceFile;
		String stateSpacefileName = ProcessUtils.generateStateSpaceFileName();
		try {
			stateSpaceFile = storageService.storeStateSpaceFile(problemForm.getStateSpace(), stateSpacefileName);
		} catch (IOException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		}

		// Process the file
		try {
			projectRepresentation = inputReader.processInputFile(stateSpaceFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (IncorrectInputException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (InvalidAttributeNameException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (UnexpectedContextException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (UnexpectedSwitchClauseException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (VarNameAlreadyInUseException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (WrongExpressionTypeException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		} catch (WrongNumberOfArgumentsException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_STATE_SPACE, e.getMessage());
		}

		// Generate .java files to a folder with generated package name
		ProjectGenerator projectGenerator = new ProjectGenerator(projectRepresentation);
		List<ClassRepresentation> classRepresentations;
		String packageName = ProcessUtils.generatePackageName();
		try {
			classRepresentations = projectGenerator.generate(generatedFolderName, packageName, true);
		} catch (IOException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		}

		// Object wrapping the created .java files information
		ClassManager classManager = new ClassManager();
		classManager.addClasses(classRepresentations);

		// SOLUTION

		// Create object that can solve problems with different type of algorithms
		SolutionManager solutionManager;
		try {

			SolutionMaker solutionMaker = new SolutionMaker(classManager.getFilePaths());
			classManager.clear();
			solutionManager = solutionMaker.start();

		} catch (TemporaryFolderCreationException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (WrongFileExtensionException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (TemporaryFolderDeletionException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (CompilationException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (OperatorNotFoundException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (OperatorInitializationException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (StateInitializationException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (StateNotFoundException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		} catch (IOException e) {
			e.printStackTrace();
			return problemResponseWithSingleError(ERROR_KEY_SERVER_SIDE, ERROR_MESSAGE_SERVER_SIDE);
		}

		// START PROCESSES

		UserDTO userDTO = userService.getUserByUsername(activeUsersUsername());

		List<String> processIdentifiers = new ArrayList<>();

		for (int i = 0; i < problemForm.getAlgorithms().size(); i++) {

			// Generate identifier for process
			String processIdentifier = ProcessUtils.generateProcessIdentifier();
			processIdentifiers.add(processIdentifier);

			// Create and store new process in database
			ProcessDTO processDTO = new ProcessDTO();
			processDTO.setName(problemForm.getName());
			processDTO.setProcessIdentifier(processIdentifier);
			processDTO.setDone(false);
			processDTO.setJavaPackageName(packageName);
			processDTO.setStateSpaceFileName(stateSpacefileName);
			processDTO.setUserId(userDTO.getId());
			processDTO.setCreationDate(new Date());
			processDTO.setSearchAlgorithm(algorithmNameToCode2(problemForm.getAlgorithms().get(i)));
			processService.save(processDTO);

			// Start the process
			ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
			processThread.setProcessIdentifier(processIdentifier);
			processThread.setSolutionManager(solutionManager);
			processThread.setProblemForm(problemForm);
			processThread.setAlgorithmIndex(i);
			threadPoolTaskExecutor.execute(processThread);

		}

		// Return response
		ProblemResponse problemResponse = new ProblemResponse();
		problemResponse.setProcessIdentifiers(processIdentifiers);
		problemResponse.setAlgorithms(algorithmNamesToCodes(problemForm.getAlgorithms()));

		return problemResponse;

	}

	private ProblemResponse problemResponseWithSingleError(String key, String value) {

		ProblemResponse problemResponse = new ProblemResponse();

		problemResponse.setError(true);

		Map<String, String> errors = new HashMap<>();
		errors.put(key, value);
		problemResponse.setErrors(errors);

		return problemResponse;

	}

	private boolean isUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return true;
		}

		return false;

	}

	private List<String> algorithmNamesToCodes(List<String> names) {

		List<String> codes = new ArrayList<>();

		for (String name : names) {

			String code = ALGORITHM_CODE_DEFAULT;

			switch (name) {
				case ALGORITHM_NAME_BACKTRACK_SIMPLE:
					code = ALGORITHM_CODE_BACKTRACK_SIMPLE;
					break;
				case ALGORITHM_NAME_BACKTRACK_CIRCLE:
					code = ALGORITHM_CODE_BACKTRACK_CIRCLE;
					break;
				case ALGORITHM_NAME_BACKTRACK_PATH_LENGTH_LIMIT:
					code = ALGORITHM_CODE_BACKTRACK_PATH_LENGTH_LIMIT;
					break;
				case ALGORITHM_NAME_BACKTRACK_OPTIMAL:
					code = ALGORITHM_CODE_BACKTRACK_OPTIMAL;
					break;
				case ALGORITHM_NAME_BREADTH_FIRST:
					code = ALGORITHM_CODE_BREADTH_FIRST;
					break;
				case ALGORITHM_NAME_DEPTH_FIRST:
					code = ALGORITHM_CODE_DEPTH_FIRST;
					break;
				case ALGORITHM_NAME_OPTIMAL:
					code = ALGORITHM_CODE_OPTIMAL;
					break;
				case ALGORITHM_NAME_BEST_FIRST:
					code = ALGORITHM_CODE_BEST_FIRST;
					break;
				case ALGORITHM_NAME_A:
					code = ALGORITHM_CODE_A;
					break;
			}

			codes.add(code);

		}

		return codes;

	}

	private String algorithmNameToCode2(String algorithmName){

		String code = "";

		switch (algorithmName) {
			case ALGORITHM_NAME_BACKTRACK_SIMPLE:
				code = ALGORITHM_CODE_2_BACKTRACK_SIMPLE;
				break;
			case ALGORITHM_NAME_BACKTRACK_CIRCLE:
				code = ALGORITHM_CODE_2_BACKTRACK_CIRCLE;
				break;
			case ALGORITHM_NAME_BACKTRACK_PATH_LENGTH_LIMIT:
				code = ALGORITHM_CODE_2_BACKTRACK_PATH_LENGTH_LIMIT;
				break;
			case ALGORITHM_NAME_BACKTRACK_OPTIMAL:
				code = ALGORITHM_CODE_2_BACKTRACK_OPTIMAL;
				break;
			case ALGORITHM_NAME_BREADTH_FIRST:
				code = ALGORITHM_CODE_2_BREADTH_FIRST;
				break;
			case ALGORITHM_NAME_DEPTH_FIRST:
				code = ALGORITHM_CODE_2_DEPTH_FIRST;
				break;
			case ALGORITHM_NAME_OPTIMAL:
				code = ALGORITHM_CODE_2_OPTIMAL;
				break;
			case ALGORITHM_NAME_BEST_FIRST:
				code = ALGORITHM_CODE_2_BEST_FIRST;
				break;
			case ALGORITHM_NAME_A:
				code = ALGORITHM_CODE_2_A;
				break;
		}

		return code;

	}

	private String activeUsersUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}


}
