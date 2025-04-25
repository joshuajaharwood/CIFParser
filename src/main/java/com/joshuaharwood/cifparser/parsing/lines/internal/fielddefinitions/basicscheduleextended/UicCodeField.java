package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

public record UicCodeField() implements BasicScheduleExtendedField<Integer> {

  @Override
  public int startIndex() {
    return 6;
  }

  @Override
  public String name() {
    return "UIC_CODE";
  }

  @Override
  public int length() {
    return 5;
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