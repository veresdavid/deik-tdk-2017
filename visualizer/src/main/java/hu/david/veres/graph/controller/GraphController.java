package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/graph")
public class GraphController {

    @Autowired
    private ProcessService processService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(name = "processIdentifier", required = false) String processIdentifier) {

        if (processIdentifier == null) {

            ModelAndView modelAndView = new ModelAndView("graph");
            return modelAndView;

        } else {

            ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);

            if (processDTO == null) {

                // TODO: property
                ModelAndView modelAndView = new ModelAndView("graph");
                modelAndView.addObject("error", "GRAPH NOT FOUND");
                return modelAndView;

            } else {

                ModelAndView modelAndView = new ModelAndView("redirect:./graph/view/" + processIdentifier);
                return modelAndView;

            }

        }

    }

    @RequestMapping(path = "/view/{processIdentifier}", method = RequestMethod.GET)
    public ModelAndView getProcess(@PathVariable("processIdentifier") String processIdentifier) {

        ModelAndView modelAndView = new ModelAndView();

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);

        modelAndView.addObject("processDTO", processDTO);

        modelAndView.setViewName("view");

        return modelAndView;

    }

}
