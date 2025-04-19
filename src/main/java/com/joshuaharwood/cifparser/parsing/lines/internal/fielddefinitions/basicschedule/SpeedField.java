package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import java.util.function.Function;

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
  public Function<String, Integer> converter() {
    return Integer::valueOf;
  }
}
