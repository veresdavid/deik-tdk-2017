package representation;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import java.util.ArrayList;
import java.util.List;

public class ClassRepresentation {

  private ClassName className;
  private List<FieldSpec> fields = new ArrayList<>();
  private String filePath;

  public ClassRepresentation() {
  }

  public ClassRepresentation(ClassName className,
      List<FieldSpec> fields, String filePath) {
    this.className = className;
    this.fields = fields;
    this.filePath = filePath;
  }

  public ClassName getClassName() {
    return className;
  }

  public void setClassName(ClassName className) {
    this.className = className;
  }

  public List<FieldSpec> getFields() {
    return fields;
  }

  public void setFields(List<FieldSpec> fields) {
    this.fields = fields;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ClassRepresentation that = (ClassRepresentation) o;

    if (className != null ? !className.equals(that.className) : that.className != null) {
      return false;
    }
    if (fields != null ? !fields.equals(that.fields) : that.fields != null) {
      return false;
    }
    return filePath != null ? filePath.equals(that.filePath) : that.filePath == null;
  }

  @Override
  public int hashCode() {
    int result = className != null ? className.hashCode() : 0;
    result = 31 * result + (fields != null ? fields.hashCode() : 0);
    result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ClassRepresentation{" +
        "className=" + className +
        ", fields=" + fields +
        ", filePath='" + filePath + '\'' +
        '}';
  }
}
