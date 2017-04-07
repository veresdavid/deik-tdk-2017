package misc;

import java.util.ArrayList;
import java.util.List;
import representation.ClassRepresentation;

public class ClassManager {

  private List<ClassRepresentation> classes = new ArrayList<>();

  public ClassManager() {
  }

  public List<ClassRepresentation> getClasses() {
    return classes;
  }

  public void setClasses(List<ClassRepresentation> classes) {
    this.classes = classes;
  }

  public List<String> getFilePaths() {
    List<String> result = new ArrayList<>();

    classes.forEach(currentClass -> result.add(currentClass.getFilePath()));

    return result;
  }

  public void addClass(ClassRepresentation classRepresentation) {
    classes.add(classRepresentation);
  }

  public void addClasses(List<ClassRepresentation> classes) {
    this.classes.addAll(classes);
  }

  public void clear() {
    this.classes.clear();
  }

}
