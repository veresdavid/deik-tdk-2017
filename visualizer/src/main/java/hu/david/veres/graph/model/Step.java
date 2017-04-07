package hu.david.veres.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Step {

    List<String> activatedNodes;
    List<String> inactivatedNodes;
    List<String> steppedOnNodes;
    List<String> closedNodes;
    List<String> activatedConnections;
    List<String> inactivatedConnections;

    public Step() {
        activatedNodes = new ArrayList<>();
        inactivatedNodes = new ArrayList<>();
        steppedOnNodes = new ArrayList<>();
        closedNodes = new ArrayList<>();
        activatedConnections = new ArrayList<>();
        inactivatedConnections = new ArrayList<>();
    }

}
