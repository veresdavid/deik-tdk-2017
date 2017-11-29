package hu.david.veres.graph.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AdminProblemResponse {

	private String processIdentifier;

	private String stateSpaceFileName;

	private String solutionFileName;

	private String javaPackageName;

	private List<String> javaFiles;

	private String name;

	private Date creationDate;

	private Long userId;

}
