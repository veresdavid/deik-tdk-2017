package hu.david.veres.graph.form;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomSearchAlgorithmData {

	private List<String> files;

	private boolean usesHeuristic;

	private List<VariableData> variables;

}
