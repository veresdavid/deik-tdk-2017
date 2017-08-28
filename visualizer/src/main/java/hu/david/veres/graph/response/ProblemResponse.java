package hu.david.veres.graph.response;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProblemResponse {

	private boolean error;
	private Map<String, String> errors;
	private List<String> processIdentifiers;
	private List<String> algorithms;

}
