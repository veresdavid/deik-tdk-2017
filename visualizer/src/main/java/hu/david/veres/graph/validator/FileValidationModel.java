package hu.david.veres.graph.validator;

import lombok.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FileValidationModel {

	private MultipartFile file;
	private boolean empty;
	private String extension;
	private long size;

	public FileValidationModel(MultipartFile file) {

		this.file = file;

		this.empty = (file == null || file.isEmpty());

		this.extension = FilenameUtils.getExtension(file.getOriginalFilename());

		this.size = file.getSize();

	}

}
