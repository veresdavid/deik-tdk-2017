package hu.david.veres.graph.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public String loadPage() {

		if (isUserLoggedIn()) {
			return "redirect:/";
		}

		return "registration";

	}

	private boolean isUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return true;
		}

		return false;

	}

}
