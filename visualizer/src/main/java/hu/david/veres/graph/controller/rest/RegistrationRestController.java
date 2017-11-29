package hu.david.veres.graph.controller.rest;

import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.form.RegistrationForm;
import hu.david.veres.graph.response.RegistrationFieldError;
import hu.david.veres.graph.response.RegistrationResponse;
import hu.david.veres.graph.service.UserService;
import hu.david.veres.graph.validator.RegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RegistrationRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RegistrationFormValidator registrationFormValidator;

	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public RegistrationResponse registration(@RequestBody RegistrationForm registrationForm, BindingResult bindingResult) {

		if (isUserLoggedIn()) {
			return new RegistrationResponse(true, null);
		}

		// validation
		registrationFormValidator.validate(registrationForm, bindingResult);

		if (bindingResult.hasErrors()) {

			RegistrationResponse registrationResponse = new RegistrationResponse();

			List<RegistrationFieldError> errors = new ArrayList<>();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errors.add(new RegistrationFieldError(fieldError.getField(), fieldError.getCode()));
			}

			registrationResponse.setError(true);
			registrationResponse.setErrors(errors);

			return registrationResponse;

		}

		// save user
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(registrationForm.getUsername());
		userDTO.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
		userDTO.setEmail(registrationForm.getEmail());
		userDTO.setRole("user");

		UserDTO savedUserDTO = userService.save(userDTO);

		// log in user
		Authentication auth = new UsernamePasswordAuthenticationToken(savedUserDTO.getUsername(), null, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		SecurityContextHolder.getContext().setAuthentication(auth);

		return new RegistrationResponse(false, null);

	}

	private boolean isUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return true;
		}

		return false;

	}

}
