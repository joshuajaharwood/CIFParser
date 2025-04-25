package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

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
  public Byte convert(String raw) {
    return Byte.parseByte(raw);
  }
}
