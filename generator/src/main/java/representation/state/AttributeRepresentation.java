package representation.state;

import misc.Dimension;
import enums.VarStruct;
import enums.VarType;

public class AttributeRepresentation {

  private String attributeName;
  private VarStruct varStruct;
  private VarType varType;
  private Dimension dimension;

  public AttributeRepresentation() {
  }

  public AttributeRepresentation(String attributeName, VarStruct varStruct, VarType varType) {
    this.attributeName = attributeName;
    this.varStruct = varStruct;
    this.varType = varType;
  }

  public AttributeRepresentation(String attributeName, VarStruct varStruct, VarType varType,
      Dimension dimension) {
    this.attributeName = attributeName;
    this.varStruct = varStruct;
    this.varType = varType;
    this.dimension = dimension;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public VarStruct getVarStruct() {
    return varStruct;
  }

  public void setVarStruct(VarStruct varStruct) {
    this.varStruct = varStruct;
  }

  public VarType getVarType() {
    return varType;
  }

  public void setVarType(VarType varType) {
    this.varType = varType;
  }

  public Dimension getDimension() {
    return dimension;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AttributeRepresentation that = (AttributeRepresentation) o;

    if (attributeName != null ? !attributeName.equals(that.attributeName)
        : that.attributeName != null) {
      return false;
    }
    if (varStruct != null ? !varStruct.equals(that.varStruct) : that.varStruct != null) {
      return false;
    }
    if (varType != null ? !varType.equals(that.varType) : that.varType != null) {
      return false;
    }
    return dimension != null ? dimension.equals(that.dimension) : that.dimension == null;
  }

  @Override
  public int hashCode() {
    int result = attributeName != null ? attributeName.hashCode() : 0;
    result = 31 * result + (varStruct != null ? varStruct.hashCode() : 0);
    result = 31 * result + (varType != null ? varType.hashCode() : 0);
    result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AttributeRepresentation{" +
        "attributeName='" + attributeName + '\'' +
        ", varStruct='" + varStruct + '\'' +
        ", varType='" + varType + '\'' +
        ", dimension=" + dimension +
        '}';
  }
}