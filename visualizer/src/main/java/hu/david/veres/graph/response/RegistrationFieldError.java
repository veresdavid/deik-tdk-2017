package hu.david.veres.graph.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationFieldError {

	private String field;
	private String message;

}
