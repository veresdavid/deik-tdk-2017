package hu.david.veres.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Result {

    private Info info;
    private List<Node> nodes;
    private List<Operator> operators;
    private List<Connection> connections;
    private List<Step> steps;
    private List<List<String>> solutions;

    public Result() {
        info = new Info();
        nodes = new ArrayList<>();
        operators = new ArrayList<>();
        connections = new ArrayList<>();
        steps = new ArrayList<>();
        solutions = new ArrayList<>();
    }

}
