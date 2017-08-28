package hu.david.veres.graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProblemController {

	@RequestMapping(path = "/problem", method = RequestMethod.GET)
	public String problemPage(Model model) {
		return "problem";
	}

}
