package hu.david.veres.graph.validator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AlgorithmFileValidator {

	private static final String FIELD_EMPTY = "empty";
	private static final String FIELD_EXTENSION = "extension";
	private static final String FIELD_SIZE = "size";

	private static final String ERROR_MESSAGE_EMPTY_FILE = "file_error_empty";
	private static final String ERROR_MESSAGE_WRONG_EXTENSION = "file_error_extension";
	private static final String ERROR_MESSAGE_BIG_FILE = "file_error_size";

	public FileValidationResult validate(FileValidationModel fileValidationModel) {

		FileValidationResult fileValidationResult = new FileValidationResult();

		Map<String, String> errors = new HashMap<>();

		// null or empty
		if (fileValidationModel.isEmpty()) {
			errors.put(FIELD_EMPTY, ERROR_MESSAGE_EMPTY_FILE);
		}

		// validate extension
		if (!fileValidationModel.getExtension().equals("java")) {
			errors.put(FIELD_EXTENSION, ERROR_MESSAGE_WRONG_EXTENSION);
		}

		// validate size
		if (fileValidationModel.getSize() >= 100 * 1024) {
			errors.put(FIELD_SIZE, ERROR_MESSAGE_BIG_FILE);
		}

		if (!errors.isEmpty()) {
			fileValidationResult.setError(true);
		}

		fileValidationResult.setErrors(errors);

		return fileValidationResult;

	}

}
