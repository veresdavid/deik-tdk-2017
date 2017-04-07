package hu.david.veres.graph.service;

import hu.david.veres.graph.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface StorageService {

    File storeUploadedFile(MultipartFile file, String newFileName) throws IOException;

    File getUploadedFile(String fileName) throws FileNotFoundException;

    void deleteUploadedFile(String fileName);

    void storeResultInJsonFile(Result result, String newFileName) throws IOException;

    File getJsonFile(String fileName) throws FileNotFoundException;

    File storeStateSpace(String stateSpace, String fileName) throws IOException;

}
