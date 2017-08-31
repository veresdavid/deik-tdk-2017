package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {

	@Autowired
	private ProcessService processService;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/profile", method = RequestMethod.GET)
	public ModelAndView loadPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profile");

		UserDTO userDTO = userService.getUserByUsername(activeUsersUsername());

		List<ProcessDTO> processDTOS = processService.getProcessesByUserId(userDTO.getId());
		modelAndView.addObject("processes", processDTOS);

		return modelAndView;

	}

	private String activeUsersUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
