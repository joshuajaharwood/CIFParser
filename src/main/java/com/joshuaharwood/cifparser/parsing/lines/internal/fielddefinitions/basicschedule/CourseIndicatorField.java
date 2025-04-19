package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import java.util.function.Function;

public record CourseIndicatorField() implements BasicScheduleField<Byte> {
  @Override
  public int startIndex() {
    return 40;
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
  public Function<String, Byte> converter() {
    return Byte::parseByte;
  }
}
