package hu.david.veres.graph.thread;

import exceptions.InvalidVariableException;
import exceptions.TypeMismatchException;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.generator.ResultGenerator;
import hu.david.veres.graph.model.Result;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.SolutionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
public class ProcessThread implements Runnable {

    private static final String ERROR_MESSAGE_SERVER_SIDE = "Server-side error! Please try again!";

    private String processIdentifier;
    private SolutionManager solutionManager;
    private ProblemForm problemForm;
    private int algorithmIndex;

    @Autowired
    private ProcessService processService;

    @Autowired
    private StorageService storageService;

    @Override
    public void run() {

        // SOLVE PROBLEM

        // Generate and get solution output file name
        String absoluteFileName = "";
        switch (problemForm.getAlgorithms().get(algorithmIndex)) {
            case "BackTrackSimple":
                absoluteFileName = solutionManager.doBackTrackSimple(problemForm.isDoTree());
                break;
            case "BackTrackCircle":
                absoluteFileName = solutionManager.doBackTrackCircle(problemForm.isDoTree());
                break;
            case "BackTrackPathLengthLimitation":
                absoluteFileName = solutionManager.doBackTrackPathLengthLimitation(problemForm.isDoTree(), problemForm.getBackTrackPathLengthLimitationLimit());
                break;
            case "BackTrackOptimal":
                absoluteFileName = solutionManager.doBackTrackOptimal(problemForm.isDoTree(), problemForm.getBackTrackOptimalLimit());
                break;
            case "BreadthFirst":
                absoluteFileName = solutionManager.doBreadthFirst(problemForm.isDoTree());
                break;
            case "DepthFirst":
                absoluteFileName = solutionManager.doDepthFirst(problemForm.isDoTree());
                break;
            case "Optimal":
                absoluteFileName = solutionManager.doOptimal(problemForm.isDoTree());
                break;
            case "BestFirst":
                try {
                    absoluteFileName = solutionManager.doBestFirst(problemForm.getHeuristic(), convertInputToSet(problemForm.getVariablesInHeuristicFunction()), problemForm.isDoTree());
                } catch (ClassNotFoundException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (NoSuchFieldException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (IllegalAccessException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (InstantiationException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (InvalidVariableException e) {
                    finishAndUpdateProcess(processIdentifier, true, e.getMessage(), null);
                    e.printStackTrace();
                    return;
                } catch (TypeMismatchException e) {
                    finishAndUpdateProcess(processIdentifier, true, e.getMessage(), null);
                    e.printStackTrace();
                    return;
                }
                break;
            case "A":
                try {
                    absoluteFileName = solutionManager.doA(problemForm.getHeuristic(), convertInputToSet(problemForm.getVariablesInHeuristicFunction()), problemForm.isDoTree());
                } catch (ClassNotFoundException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (NoSuchFieldException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (IllegalAccessException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (InstantiationException e) {
                    finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
                    e.printStackTrace();
                    return;
                } catch (InvalidVariableException e) {
                    finishAndUpdateProcess(processIdentifier, true, e.getMessage(), null);
                    e.printStackTrace();
                    return;
                } catch (TypeMismatchException e) {
                    finishAndUpdateProcess(processIdentifier, true, e.getMessage(), null);
                    e.printStackTrace();
                    return;
                }
                break;
        }

        // GENERATE JSON

        // Check if file exists
        File file = new File(absoluteFileName);
        if (!file.exists()) {
            finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
            return;
        }

        // Generate result
        Result result;
        try {
            ResultGenerator resultGenerator = new ResultGenerator();
            result = resultGenerator.generate(file);
        } catch (IOException e) {
            finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
            e.printStackTrace();
            return;
        }

        // Store JSON file
        try {
            storageService.storeResultInJsonFile(result, processIdentifier);
        } catch (IOException e) {
            finishAndUpdateProcess(processIdentifier, true, ERROR_MESSAGE_SERVER_SIDE, null);
            e.printStackTrace();
            return;
        }

        // Update database
        String solutionFileName = file.getName().substring(0, file.getName().indexOf('.'));
        finishAndUpdateProcess(processIdentifier, false, null, solutionFileName);

    }

    private void finishAndUpdateProcess(String processIdentifier, boolean error, String errorMessage, String solutionFileName) {

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);
        processDTO.setDone(true);
        processDTO.setError(error);
        processDTO.setErrorMessage(errorMessage);
        processDTO.setSolutionFileName(solutionFileName);
        processService.save(processDTO);

    }

    private Set<String> convertInputToSet(String input) {

        if (input.isEmpty()) {
            return new HashSet<>();
        }

        String[] parts = input.split(", ");

        return Arrays.stream(parts).collect(Collectors.toSet());

    }

}
