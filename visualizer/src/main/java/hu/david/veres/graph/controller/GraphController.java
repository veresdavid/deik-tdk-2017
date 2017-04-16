package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/graph")
public class GraphController {

    @Value("${file.generated.folder}")
    private String generatedFolderName;

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

                ModelAndView modelAndView = new ModelAndView("graph");
                modelAndView.addObject("error", "Graph not found!");
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
        modelAndView.addObject("javaFileNames", getFileNamesInPackageFolder(processDTO.getJavaPackageName()));

        modelAndView.setViewName("view");

        return modelAndView;

    }

    private List<String> getFileNamesInPackageFolder(String packageName){

        List<String> fileNames = new ArrayList<>();

        File folderLocation = new File(generatedFolderName + File.separator + packageName.replace('.', File.separatorChar));

        for(File file : folderLocation.listFiles()){

            fileNames.add(file.getName().substring(0, file.getName().indexOf('.')));

        }

        return fileNames;

    }

}
