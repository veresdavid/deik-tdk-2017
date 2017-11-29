package hu.david.veres.graph.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProcessDTO {

    private Long id;
    private String processIdentifier;
    private boolean done;
    private boolean error;
    private String errorMessage;
    private String stateSpaceFileName;
    private String solutionFileName;
    private String javaPackageName;
    private String name;
    private Date creationDate;
    private Long userId;
    private String searchAlgorithm;
    private String status;
    private String customFiles;
    private String heuristic;
    private String variablesInHeuristicFunction;
    private boolean usesHeuristic;
    private String variableData;

}
