package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

public final class SpeedField implements ChangeEnRouteField<Integer> {
  SpeedField() {
  }

  @Override
  public int startIndex() {
    return 37;
  }

  @Override
  public String name() {
    return "SPEED";
  }

  @Override
  public int length() {
    return 3;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Integer convert(String raw) {
    return Integer.valueOf(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "SpeedField[]";
  }

}