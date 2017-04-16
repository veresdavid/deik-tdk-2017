package representation.operator;

public class ParameterRepresentation {
  private String parameterName;
  private Double from;
  private Double to;
  private Double by;

  public ParameterRepresentation() {
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public Double getFrom() {
    return from;
  }

  public void setFrom(Double from) {
    this.from = from;
  }

  public Double getTo() {
    return to;
  }

  public void setTo(Double to) {
    this.to = to;
  }

  public Double getBy() {
    return by;
  }

  public void setBy(Double by) {
    this.by = by;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ParameterRepresentation that = (ParameterRepresentation) o;

    if (parameterName != null ? !parameterName.equals(that.parameterName) : that.parameterName != null) {
      return false;
    }
    if (from != null ? !from.equals(that.from) : that.from != null) {
      return false;
    }
    if (to != null ? !to.equals(that.to) : that.to != null) {
      return false;
    }
    return by != null ? by.equals(that.by) : that.by == null;
  }

  @Override
  public int hashCode() {
    int result = parameterName != null ? parameterName.hashCode() : 0;
    result = 31 * result + (from != null ? from.hashCode() : 0);
    result = 31 * result + (to != null ? to.hashCode() : 0);
    result = 31 * result + (by != null ? by.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ParameterRepresentation{" +
        "parameterName='" + parameterName + '\'' +
        ", from=" + from +
        ", to=" + to +
        ", by=" + by +
        '}';
  }
}
