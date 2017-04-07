package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtil;

public class ProjectGenerator {

  private static final String GENERATED_UTILS_CONTENT_FILENAME = "GeneratedUtilsContent.txt";
  private static final String GENERATED_UTILS_FILENAME = "GeneratedUtils";

  private ProjectRepresentation projectRepresentation;

  public ProjectGenerator(ProjectRepresentation projectRepresentation) {
    this.projectRepresentation = projectRepresentation;
  }

  public List<ClassRepresentation> generate(String directoryName,
      String packageName, boolean keepTogetherGettersAndSetters)
      throws IOException {

    List<ClassRepresentation> result = new ArrayList<>();

    OperatorGenerator operatorGenerator = new OperatorGenerator();
    StateGenerator stateGenerator = new StateGenerator();

    StateRepresentation stateRepresentation = projectRepresentation.getStateRepresentation();
    String stateFileName = projectRepresentation.getStateRepresentation().getName();

    ClassRepresentation stateClass = stateGenerator
        .generate(stateRepresentation, directoryName, packageName, stateFileName, keepTogetherGettersAndSetters);

    result.add(stateClass);

    for (OperatorRepresentation operator : projectRepresentation.getOperatorRepresentation()) {
      ClassRepresentation operatorClass = operatorGenerator
          .generate(operator, stateClass, directoryName, packageName, operator.getName(),
              keepTogetherGettersAndSetters);

      result.add(operatorClass);
    }

    ClassRepresentation generatedUtilsClassRepresentation = copyGeneratedUtils(directoryName,
        packageName);

    result.add(generatedUtilsClassRepresentation);
    return result;
  }

  private ClassRepresentation copyGeneratedUtils(String directoryName, String packageName)
      throws IOException {
    ClassRepresentation generatedUtilsClassRepresentation = new ClassRepresentation();
    generatedUtilsClassRepresentation
        .setFilePath(
            GeneratorUtil.getFilePath(directoryName, packageName, GENERATED_UTILS_FILENAME));

    File resultFile = new File(
        GeneratorUtil.getFilePath(directoryName, packageName, "GeneratedUtils"));

    InputStream generatedUtilsContent = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream(GENERATED_UTILS_CONTENT_FILENAME);

    BufferedReader reader = new BufferedReader(new InputStreamReader(generatedUtilsContent));
    BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile));

    String importLine = "package " + packageName + ";\n\n";
    writer.append(importLine);

    String currentLine;
    while ((currentLine = reader.readLine()) != null) {
      writer.append(currentLine);
      writer.newLine();
    }

    writer.close();
    reader.close();

    return generatedUtilsClassRepresentation;
  }
}