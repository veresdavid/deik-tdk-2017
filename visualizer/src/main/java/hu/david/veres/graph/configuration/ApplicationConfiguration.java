package hu.david.veres.graph.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("hu.david.veres.graph")
public class ApplicationConfiguration {

    @Value("${file.upload.folder}")
    private String fileUploadFolderName;

    @Value("${file.json.folder}")
    private String jsonFolderName;

    @Value("${file.state.space.folder}")
    private String stateSpaceFolderName;

    @PostConstruct
    private void init() {
        createFileUploadFolder();
        createJsonFolder();
        createStateSpaceFolder();
    }

    private void createFileUploadFolder() {
        File fileUploadFolder = new File(fileUploadFolderName);
        if (!fileUploadFolder.exists()) {
            fileUploadFolder.mkdir();
        }
    }

    private void createJsonFolder() {
        File fileUploadFolder = new File(jsonFolderName);
        if (!fileUploadFolder.exists()) {
            fileUploadFolder.mkdir();
        }
    }

    private void createStateSpaceFolder() {
        File fileUploadFolder = new File(stateSpaceFolderName);
        if (!fileUploadFolder.exists()) {
            fileUploadFolder.mkdir();
        }
    }

    // Bean for accessing properties.

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // Bean for threads.

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(5);
        pool.setMaxPoolSize(10);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

    // Bean for JSON conversion.

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // Bean for conversion between entities and dtos

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
