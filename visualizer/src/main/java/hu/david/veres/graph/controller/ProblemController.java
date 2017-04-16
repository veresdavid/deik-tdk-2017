package hu.david.veres.graph.controller;

import exceptions.*;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProblemController {

    private static final String ERROR_MESSAGE_SERVER_SIDE = "Server-side error! Please try again or come back later!";

    @Value("${file.generated.folder}")
    private String generatedFolderName;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProblemFormValidator problemFormValidator;

    @RequestMapping(path = "/problem", method = RequestMethod.GET)
    public String problemPage(Model model) {
        model.addAttribute("problemForm", new ProblemForm());
        return "problem";
    }

    @RequestMapping(path = "/problem", method = RequestMethod.POST)
    public ModelAndView problemPost(@ModelAttribute("problemForm") ProblemForm problemForm, BindingResult bindingResult) {

        // FORM VALIDATION
        problemFormValidator.validate(problemForm, bindingResult);

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getCode());
            }
            return errorModelAndView(errorMessages);
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
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        }

        // Process the file
        try {
            projectRepresentation = inputReader.processInputFile(stateSpaceFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (InvalidAttributeNameException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (UnexpectedContextException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (UnexpectedSwitchClauseException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (VarNameAlreadyInUseException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (WrongExpressionTypeException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        } catch (WrongNumberOfArgumentsException e) {
            e.printStackTrace();
            return errorModelAndView(e.getMessage());
        }

        // Generate .java files to a folder with generated package name
        ProjectGenerator projectGenerator = new ProjectGenerator(projectRepresentation);
        List<ClassRepresentation> classRepresentations;
        String packageName = ProcessUtils.generatePackageName();
        try {
            classRepresentations = projectGenerator.generate(generatedFolderName, packageName, true);
        } catch (IOException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
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
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (WrongFileExtensionException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (TemporaryFolderDeletionException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (CompilationException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (OperatorNotFoundException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (OperatorInitializationException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (StateInitializationException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (StateNotFoundException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        } catch (IOException e) {
            e.printStackTrace();
            return errorModelAndView(ERROR_MESSAGE_SERVER_SIDE);
        }

        // START PROCESSES


        List<String> processIdentifiers = new ArrayList<>();

        for (int i = 0; i < problemForm.getAlgorithms().size(); i++) {

            // Generate identifier for process
            String processIdentifier = ProcessUtils.generateProcessIdentifier();
            processIdentifiers.add(processIdentifier);

            // Create and store new process in database
            ProcessDTO processDTO = new ProcessDTO();
            processDTO.setProcessIdentifier(processIdentifier);
            processDTO.setDone(false);
            processDTO.setJavaPackageName(packageName);
            processDTO.setStateSpaceFileName(stateSpacefileName);
            processService.save(processDTO);

            // Start the process
            ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
            processThread.setProcessIdentifier(processIdentifier);
            processThread.setSolutionManager(solutionManager);
            processThread.setProblemForm(problemForm);
            processThread.setAlgorithmIndex(i);
            threadPoolTaskExecutor.execute(processThread);

        }

        // Create and return ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("processIdentifiers", processIdentifiers);
        modelAndView.addObject("algorithms", problemForm.getAlgorithms());
        modelAndView.setViewName("visualizer");

        return modelAndView;

    }

    private ModelAndView errorModelAndView(String errorMessage) {

        return errorModelAndView(Arrays.asList(errorMessage));

    }

    private ModelAndView errorModelAndView(List<String> errorMessages) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("problem");
        modelAndView.addObject("errorMessages", errorMessages);

        return modelAndView;

    }

}
