package hu.david.veres.graph.controller;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.response.AdminProblemResponse;
import hu.david.veres.graph.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

	@Value("${file.generated.folder}")
	private String generatedFolderName;

	@Autowired
	private ProcessService processService;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public ModelAndView loadPage() {

		ModelAndView modelAndView = new ModelAndView("admin");

		List<ProcessDTO> processDTOList = processService.getWaitingProcesses();

		List<AdminProblemResponse> adminProblemResponses = new ArrayList<>();

		for (ProcessDTO processDTO : processDTOList) {

			AdminProblemResponse adminProblemResponse = new AdminProblemResponse();

			adminProblemResponse.setProcessIdentifier(processDTO.getProcessIdentifier());
			adminProblemResponse.setStateSpaceFileName(processDTO.getStateSpaceFileName());
			adminProblemResponse.setSolutionFileName(processDTO.getSolutionFileName());
			adminProblemResponse.setJavaPackageName(processDTO.getJavaPackageName());
			adminProblemResponse.setJavaFiles(getCustomFilesInList(processDTO.getCustomFiles()));
			adminProblemResponse.setName(processDTO.getName());
			adminProblemResponse.setCreationDate(processDTO.getCreationDate());
			adminProblemResponse.setUserId(processDTO.getUserId());

			adminProblemResponses.add(adminProblemResponse);

		}

		modelAndView.addObject("waitingProcesses", adminProblemResponses);

		return modelAndView;

	}

	private List<String> getFileNamesInPackageFolder(String packageName) {

		List<String> fileNames = new ArrayList<>();

		File folderLocation = new File(generatedFolderName + File.separator + packageName.replace('.', File.separatorChar));

		for (File file : folderLocation.listFiles()) {

			fileNames.add(file.getName().substring(0, file.getName().indexOf('.')));

		}

		return fileNames;

	}

	private List<String> getCustomFilesInList(String customFiles) {

		List<String> customFilesList = Arrays.asList(customFiles.split(";"));

		for (String customFile : customFilesList) {
			customFile.replace("\\", "/");
		}

		return customFilesList;

	}

}
