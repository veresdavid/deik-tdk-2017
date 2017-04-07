package misc;

public class Dimension {
  String dimensionN;
  String dimensionM;

  public Dimension() {
  }

  public Dimension(String dimensionN, String dimensionM) {
    this.dimensionN = dimensionN;
    this.dimensionM = dimensionM;
  }

  public String getDimensionN() {
    return dimensionN;
  }

  public void setDimensionN(String dimensionN) {
    this.dimensionN = dimensionN;
  }

  public String getDimensionM() {
    return dimensionM;
  }

  public void setDimensionM(String dimensionM) {
    this.dimensionM = dimensionM;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Dimension dimension = (Dimension) o;

    if (dimensionN != null ? !dimensionN.equals(dimension.dimensionN)
        : dimension.dimensionN != null) {
      return false;
    }
    return dimensionM != null ? dimensionM.equals(dimension.dimensionM)
        : dimension.dimensionM == null;
  }

  @Override
  public int hashCode() {
    int result = dimensionN != null ? dimensionN.hashCode() : 0;
    result = 31 * result + (dimensionM != null ? dimensionM.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Dimension{" +
        "dimensionN='" + dimensionN + '\'' +
        ", dimensionM='" + dimensionM + '\'' +
        '}';
  }
}
