package hu.david.veres.graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String loadPage(){
        return "redirect:./problem";
    }

}
