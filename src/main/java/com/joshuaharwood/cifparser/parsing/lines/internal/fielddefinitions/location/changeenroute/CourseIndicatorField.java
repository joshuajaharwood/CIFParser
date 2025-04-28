package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class CourseIndicatorField implements ChangeEnRouteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

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
  public String convert(String raw) {
    return CONVERTER.apply(raw);
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
    return "CourseIndicatorField[]";
  }

}