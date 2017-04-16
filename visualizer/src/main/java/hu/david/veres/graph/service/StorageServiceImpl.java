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
    private static final String EXTENSION_JAVA = ".java";

    @Value("${file.json.folder}")
    private String jsonFolderName;

    @Value("${file.state.space.folder}")
    private String stateSpaceFolderName;

    @Value("${file.generated.folder}")
    private String generatedFolderName;

    @Value("${file.solution.outputs.folder}")
    private String solutionOutputsFolderName;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void storeResultInJsonFile(Result result, String newFileName) throws IOException {

        File file = new File(jsonFolderName + File.separator + newFileName + EXTENSION_JSON);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, result);

    }

    @Override
    public File getJsonFile(String fileName) throws FileNotFoundException {

        File file = new File(jsonFolderName + File.separator + fileName + EXTENSION_JSON);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }

    @Override
    public File storeStateSpaceFile(String stateSpace, String fileName) throws IOException {

        File file = new File(stateSpaceFolderName + File.separator + fileName + EXTENSION_TXT);

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(stateSpace);

        fileWriter.close();

        return file;

    }

    @Override
    public File getStateSpaceFile(String fileName) throws FileNotFoundException {

        File file = new File(stateSpaceFolderName + File.separator + fileName + EXTENSION_TXT);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }

    @Override
    public File getSolutionFile(String fileName) throws FileNotFoundException {

        File file = new File(solutionOutputsFolderName + File.separator + fileName + EXTENSION_TXT);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }

    @Override
    public File getJavaFile(String packageName, String fileName) throws FileNotFoundException {

        String packageLocation = packageName.replace('.', File.separatorChar);

        File file = new File(generatedFolderName + File.separator + packageLocation + File.separator + fileName + EXTENSION_JAVA);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file;

    }
}
