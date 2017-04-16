package hu.david.veres.graph.service;

import hu.david.veres.graph.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface StorageService {

    void storeResultInJsonFile(Result result, String newFileName) throws IOException;

    File getJsonFile(String fileName) throws FileNotFoundException;

    File storeStateSpaceFile(String stateSpace, String fileName) throws IOException;

    File getStateSpaceFile(String fileName) throws FileNotFoundException;

    File getSolutionFile(String fileName) throws FileNotFoundException;

    File getJavaFile(String packageName, String fileName) throws FileNotFoundException;

}
