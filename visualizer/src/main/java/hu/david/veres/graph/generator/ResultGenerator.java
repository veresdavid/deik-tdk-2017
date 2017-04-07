package hu.david.veres.graph.generator;

import hu.david.veres.graph.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultGenerator {

    private static final String DELIMITER_PIPE = "\\|";
    private static final String DELIMITER_SPACE = " ";
    private static final String DELIMITER_CLOSE_SQUARE_BRACKET = "\\]";
    private static final String DELIMITER_COMMA_AND_SPACE = ", ";
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final String EMPTY_LINE = "";

    private static final String LABEL_INFO = "info";
    private static final String LABEL_NODES = "nodes";
    private static final String LABEL_OPERATORS = "operators";
    private static final String LABEL_CONNECTIONS = "connections";
    private static final String LABEL_STEPS = "steps";
    private static final String LABEL_SOLUTIONS = "solutions";

    private static final int STATE_EMPTY = 0;
    private static final int STATE_INFO = 1;
    private static final int STATE_NODES = 2;
    private static final int STATE_OPERATORS = 3;
    private static final int STATE_CONNECTIONS = 4;
    private static final int STATE_STEPS = 5;
    private static final int STATE_SOLUTION = 6;

    private int state;
    private Result result;

    public Result generate(File file) throws IOException {

        result = new Result();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {

            switch (line) {
                case LABEL_INFO:
                    state = STATE_INFO;
                    processInfos(reader);
                    break;
                case LABEL_NODES:
                    state = STATE_NODES;
                    break;
                case LABEL_OPERATORS:
                    state = STATE_OPERATORS;
                    break;
                case LABEL_CONNECTIONS:
                    state = STATE_CONNECTIONS;
                    break;
                case LABEL_STEPS:
                    state = STATE_STEPS;
                    break;
                case LABEL_SOLUTIONS:
                    state = STATE_SOLUTION;
                    break;
                case EMPTY_LINE:
                    break;
                default:
                    processLine(line);
                    break;
            }

        }

        reader.close();

        return result;

    }

    private void processLine(String line) {

        switch (state) {
            case STATE_EMPTY:
                break;
            case STATE_INFO:
                break;
            case STATE_NODES:
                processNode(line);
                break;
            case STATE_OPERATORS:
                processOperator(line);
                break;
            case STATE_CONNECTIONS:
                processConnection(line);
                break;
            case STATE_STEPS:
                processSteps(line);
                break;
            case STATE_SOLUTION:
                processSolution(line);
                break;
        }

    }

    private void processInfos(BufferedReader reader) throws IOException {

        String searchAlgorithmName = reader.readLine();
        result.getInfo().setSearchAlgorithmName(searchAlgorithmName);

    }

    private void processNode(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Node node = new Node();
        node.setId(parts[0]);
        node.setInformation(parts[1]);

        result.getNodes().add(node);

    }

    private void processOperator(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Operator operator = new Operator();
        operator.setId(parts[0]);
        operator.setInformation(parts[1]);

        result.getOperators().add(operator);

    }

    private void processConnection(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Connection connection = new Connection();
        connection.setSource(parts[0]);
        connection.setTarget(parts[1]);
        connection.setOperatorId(parts[2]);

        result.getConnections().add(connection);

    }

    private void processSteps(String line) {

        String[] parts = line.split(DELIMITER_CLOSE_SQUARE_BRACKET);

        Step step = new Step();

        step.setActivatedNodes(extractStringListFromStepPart(parts[0]));
        step.setInactivatedNodes(extractStringListFromStepPart(parts[1]));
        step.setSteppedOnNodes(extractStringListFromStepPart(parts[2]));
        step.setClosedNodes(extractStringListFromStepPart(parts[3]));
        step.setActivatedConnections(extractStringListFromStepPart(parts[4]));
        step.setInactivatedConnections(extractStringListFromStepPart(parts[5]));

        result.getSteps().add(step);

    }

    private List<String> extractStringListFromStepPart(String part) {

        String values = part.substring(part.indexOf(OPEN_SQUARE_BRACKET) + 1);

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.asList(values.split(DELIMITER_COMMA_AND_SPACE));

    }

    private void processSolution(String line) {

        String[] parts = line.split(DELIMITER_SPACE);

        result.getSolutions().add(Arrays.asList(parts));

    }

}
