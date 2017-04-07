package hu.david.veres.graph.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.david.veres.graph.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {

    private static final String EXTENSION_TXT = ".txt";
    private static final String EXTENSION_JSON = ".json";
    private static final String SLASH = "/";

    @Value("${file.upload.folder}")
    private String fileUploadFolderName;

    @Value("${file.json.folder}")
    private String jsonFolderName;

    @Value("${file.state.space.folder}")
    private String stateSpaceFolderName;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public File storeUploadedFile(MultipartFile file, String newFileName) throws IOException {

        File newFile = new File(fileUploadFolderName + SLASH + newFileName + EXTENSION_TXT);

        file.transferTo(newFile);

        return newFile;

    }

    @Override
    public File getUploadedFile(String fileName) throws FileNotFoundException {

        File file = new File(fileUploadFolderName + SLASH + fileName + EXTENSION_TXT);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }

    @Override
    public void deleteUploadedFile(String fileName) {

        File file = new File(fileUploadFolderName + SLASH + fileName + EXTENSION_TXT);

        if (file.exists()) {

            file.delete();

        }

    }

    @Override
    public void storeResultInJsonFile(Result result, String newFileName) throws IOException {

        File file = new File(jsonFolderName + SLASH + newFileName + EXTENSION_JSON);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, result);

    }

    @Override
    public File getJsonFile(String fileName) throws FileNotFoundException {

        File file = new File(jsonFolderName + SLASH + fileName + EXTENSION_JSON);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }

    @Override
    public File storeStateSpace(String stateSpace, String fileName) throws IOException {

        File file = new File(stateSpaceFolderName + SLASH + fileName + EXTENSION_TXT);

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(stateSpace);

        fileWriter.close();

        return file;

    }
}
