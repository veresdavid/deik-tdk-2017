package hu.david.veres.graph.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationResponse {

	private boolean error;
	private List<RegistrationFieldError> errors;

}
