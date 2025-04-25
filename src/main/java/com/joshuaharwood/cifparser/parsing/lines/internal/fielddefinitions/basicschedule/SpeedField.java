package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

public record SpeedField() implements BasicScheduleField<Integer> {
  @Override
  public int startIndex() {
    return 57;
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
}
