package hu.david.veres.graph.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FileUploadResponse {

	private int index;
	private String name;

}
