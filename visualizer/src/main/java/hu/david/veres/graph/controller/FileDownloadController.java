package hu.david.veres.graph.controller;

import hu.david.veres.graph.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping(path = "/file")
public class FileDownloadController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(path = "/json/{fileName}", method = RequestMethod.GET)
    public void downloadJsonFile(HttpServletResponse response, @PathVariable("fileName") String fileName) {

        try {

            File file = storageService.getJsonFile(fileName);

            response.setContentType("text/plain");

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/solution/{fileName}", method = RequestMethod.GET)
    public void downloadSolutionFile(HttpServletResponse response, @PathVariable("fileName") String fileName) {

        try {

            File file = storageService.getSolutionFile(fileName);

            response.setContentType("text/plain");

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/java/{packageName}/{fileName}", method = RequestMethod.GET)
    public void downloadJavaFile(HttpServletResponse response, @PathVariable("packageName") String packageName, @PathVariable("fileName") String fileName) {

        try {

            File file = storageService.getJavaFile(packageName, fileName);

            response.setContentType("text/plain");

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(path = "/statespace/{fileName}", method = RequestMethod.GET)
    public void downloadStateSpaceFile(HttpServletResponse response, @PathVariable("fileName") String fileName) {

        try {

            File file = storageService.getStateSpaceFile(fileName);

            response.setContentType("text/plain");

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
