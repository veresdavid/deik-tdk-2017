package hu.david.veres.graph.form;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationForm {

	private String username;
	private String password;
	private String confirmPassword;
	private String email;

}
