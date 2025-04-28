package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

public non-sealed class SpeedField implements ChangeEnRouteField<Integer> {

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
  public String toString() {
    return "SpeedField[]";
  }

}