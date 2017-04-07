package hu.david.veres.graph.form;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProblemForm {

    @NotNull
    @NotEmpty
    private String stateSpace;

    @NotNull
    @NotEmpty
    private List<String> algorithms;

    @NotNull
    private String heuristic;

}
