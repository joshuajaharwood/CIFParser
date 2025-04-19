package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import java.util.function.Function;

public record BusinessSectorPortionIdField() implements BasicScheduleField<Character> {

  @Override
  public int startIndex() {
    return 49;
  }

  @Override
  public String name() {
    return "BUSINESS_SECTOR_PORTION_ID";
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
  public Function<String, Character> converter() {
    return s -> s.charAt(0);
  }
}
