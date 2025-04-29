package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;


public non-sealed class CourseIndicatorField implements ChangeEnRouteField<Byte> {

  CourseIndicatorField() {
  }

  @Override
  public int startIndex() {
    return 20;
  }

  @Override
  public String name() {
    return "COURSE_INDICATOR";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Byte convert(String raw) {
    return Byte.parseByte(raw);
  }
  
  @Override
  public String toString() {
    return "CourseIndicatorField[]";
  }
}