package hu.david.veres.graph.controller;

import exceptions.CompilationException;
import exceptions.IncorrectInputException;
import exceptions.OperatorInitializationException;
import exceptions.OperatorNotFoundException;
import exceptions.StateInitializationException;
import exceptions.StateNotFoundException;
import exceptions.TemporaryFolderCreationException;
import exceptions.TemporaryFolderDeletionException;
import exceptions.WrongFileExtensionException;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.thread.ProcessThread;
import hu.david.veres.graph.util.ProcessUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import main.SolutionMaker;
import main.SolutionManager;
import misc.ClassManager;
import misc.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

@Controller
public class ProblemController {

  private static final String GENERATED_FOLDER_NAME = "generated";
  private static final String ERROR_MESSAGE_IOEXCEPTION = "IOException";
  private static final String ERROR_MESSAGE_TMP = "Temporary error message!";

  @Autowired
  private ProcessService processService;

  @Autowired
  private ThreadPoolTaskExecutor threadPoolTaskExecutor;

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private StorageService storageService;

  @RequestMapping(path = "/problem", method = RequestMethod.GET)
  public String problemPage(Model model) {
    model.addAttribute("problemForm", new ProblemForm());
    return "problem";
  }

  @RequestMapping(path = "/problem", method = RequestMethod.POST)
  public ModelAndView problemPost(@Valid @ModelAttribute("problemForm") ProblemForm problemForm,
      BindingResult bindingResult) {

    // FORM VALIDATION

    // If form has errors, return
    if (bindingResult.hasErrors()) {
      return errorModelAndView(ERROR_MESSAGE_TMP);
    }

    // SML

    // Objects for Java file generation
    StateGenerator stateGenerator = new StateGenerator();
    OperatorGenerator operatorGenerator = new OperatorGenerator();
    InputReader inputReader = new InputReader();
    ProjectRepresentation projectRepresentation;

    // Store state-space description to a file
    File file;
    String fileName = ProcessUtils.generateStateSpaceFileName();
    try {
      file = storageService.storeStateSpace(problemForm.getStateSpace(), fileName);
    } catch (IOException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_IOEXCEPTION);
    }

    // Process the file
    try {
      projectRepresentation = inputReader.processInputFile(file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_IOEXCEPTION);
    } catch (IncorrectInputException e) {
      System.out.println(e.getMsg());
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    }

    // Generate .java files to a folder with generated package name
    ProjectGenerator projectGenerator = new ProjectGenerator(projectRepresentation);
    List<ClassRepresentation> classRepresentations;
    try {
      classRepresentations = projectGenerator.generate(GENERATED_FOLDER_NAME,
          ProcessUtils.generatePackageName(), true);
    } catch (IOException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_IOEXCEPTION);
    }

    // Object wrapping the created .java files information
    ClassManager classManager = new ClassManager();
    classManager.addClasses(classRepresentations);

    System.out.println(classManager.getFilePaths());

    // SOLUTION

    // Create object that can solve problems with different type of algorithms
    SolutionManager solutionManager;
    try {

      SolutionMaker solutionMaker = new SolutionMaker(classManager.getFilePaths());
      classManager.clear();
      solutionManager = solutionMaker.start();

    } catch (TemporaryFolderCreationException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (WrongFileExtensionException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (TemporaryFolderDeletionException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (CompilationException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (OperatorNotFoundException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (OperatorInitializationException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (StateInitializationException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (StateNotFoundException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_TMP);
    } catch (IOException e) {
      e.printStackTrace();
      return errorModelAndView(ERROR_MESSAGE_IOEXCEPTION);
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
      processService.save(processDTO);

      // Start the process
      ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
      processThread.setProcessIdentifier(processIdentifier);
      processThread.setSolutionManager(solutionManager);
      processThread.setAlgorithmName(problemForm.getAlgorithms().get(i));
      processThread.setHeuristicFunction(problemForm.getHeuristic());
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

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("problem");
    modelAndView.addObject("errorMessage", errorMessage);

    return modelAndView;

  }

}
