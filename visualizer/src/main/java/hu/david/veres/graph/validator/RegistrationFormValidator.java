package hu.david.veres.graph.validator;

import hu.david.veres.graph.form.RegistrationForm;
import hu.david.veres.graph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationFormValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

	private static final String ERROR_USERNAME_INVALID_CHARACTERS = "registartion_error_username_ivalid_characters";
	private static final String ERROR_USERNAME_LENGTH = "registartion_error_username_length";
	private static final String ERROR_USERNAME_IN_USE = "registartion_error_username_in_use";
	private static final String ERROR_PASSWORD_LENGTH = "registartion_error_password_length";
	private static final String ERROR_PASSWORD_CONFIRM = "registartion_error_password_confirm";
	private static final String ERROR_EMAIL_INVALID = "registartion_error_email_invalid";
	private static final String ERROR_EMAIL_LENGTH = "registartion_error_email_length";
	private static final String ERROR_EMAIL_IN_USE = "registartion_error_email_in_use";

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return RegistrationForm.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		RegistrationForm registrationForm = (RegistrationForm) o;

		Pattern pattern = null;
		Matcher matcher = null;

		// validate username
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(registrationForm.getUsername());

		if (!matcher.matches()) {
			errors.rejectValue("username", ERROR_USERNAME_INVALID_CHARACTERS);
		} else if (registrationForm.getUsername().length() < 4 || registrationForm.getUsername().length() > 20) {
			errors.rejectValue("username", ERROR_USERNAME_LENGTH);
		} else if (userService.isThereUserWithUsername(registrationForm.getUsername())) {
			errors.rejectValue("username", ERROR_USERNAME_IN_USE);
		}

		// validate password
		if (registrationForm.getPassword().length() < 6 || registrationForm.getPassword().length() > 30) {
			errors.rejectValue("password", ERROR_PASSWORD_LENGTH);
		} else if (!registrationForm.getPassword().equals(registrationForm.getConfirmPassword())) {
			errors.rejectValue("password", ERROR_PASSWORD_CONFIRM);
		}

		// validate e-mail
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(registrationForm.getEmail());

		if (!matcher.matches()) {
			errors.rejectValue("email", ERROR_EMAIL_INVALID);
		} else if (registrationForm.getEmail().length() > 40) {
			errors.rejectValue("email", ERROR_EMAIL_LENGTH);
		} else if (userService.isThereUserWithEmail(registrationForm.getEmail())) {
			errors.rejectValue("email", ERROR_EMAIL_IN_USE);
		}

	}

}
