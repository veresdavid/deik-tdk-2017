package hu.david.veres.graph.dto;

import lombok.*;

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

}
