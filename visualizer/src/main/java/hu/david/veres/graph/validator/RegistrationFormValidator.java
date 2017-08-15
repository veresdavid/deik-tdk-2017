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
			errors.rejectValue("username", "Username contains invalid characters!");
		} else if (registrationForm.getUsername().length() < 4 || registrationForm.getUsername().length() > 20) {
			errors.rejectValue("username", "Username's length must be between 4 and 20 characters!");
		} else if (userService.isThereUserWithUsername(registrationForm.getUsername())) {
			errors.rejectValue("username", "Username is already in use!");
		}

		// validate password
		if (registrationForm.getPassword().length() < 6 || registrationForm.getPassword().length() > 30) {
			errors.rejectValue("password", "Password's length must be betweeen 6 and 30 characters!");
		} else if (!registrationForm.getPassword().equals(registrationForm.getConfirmPassword())) {
			errors.rejectValue("password", "Passwords do not match!");
		}

		// validate e-mail
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(registrationForm.getEmail());

		if (!matcher.matches()) {
			errors.rejectValue("email", "E-mail contains invalid characters!");
		} else if (registrationForm.getEmail().length() > 40) {
			errors.rejectValue("email", "E-mail's length can't be longer than 40 characters!");
		} else if (userService.isThereUserWithEmail(registrationForm.getEmail())) {
			errors.rejectValue("email", "E-mail is already in use!");
		}

	}

}
