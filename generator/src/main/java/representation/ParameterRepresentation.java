package representation;

public class ParameterRepresentation {
  private String parameterName;
  private Integer from;
  private Integer to;
  private Integer by;

  public ParameterRepresentation() {
  }

  public ParameterRepresentation(String parameterName, Integer from, Integer to, Integer by) {
    this.parameterName = parameterName;
    this.from = from;
    this.to = to;
    this.by = by;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public Integer getFrom() {
    return from;
  }

  public void setFrom(Integer from) {
    this.from = from;
  }

  public Integer getTo() {
    return to;
  }

  public void setTo(Integer to) {
    this.to = to;
  }

  public Integer getBy() {
    return by;
  }

  public void setBy(Integer by) {
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

    if (parameterName != null ? !parameterName.equals(that.parameterName)
        : that.parameterName != null) {
      return false;
    }
    if (from != null ? !from.equals(that.from) : that.from != null) {
      return false;
    }
    if (to != null ? !to.equals(that.to) : that.to != null) {
      return false;
    }
    if (by != null ? !by.equals(that.by) : that.by != null) {
      return false;
    }

    return true;
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
