package hu.david.veres.graph.validator;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FileValidationResult {

	private boolean error;
	private Map<String, String> errors;

}
