package hu.david.veres.graph.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {

	private Long id;

	private String username;

	private String email;

	private String password;

	private String role;

}
