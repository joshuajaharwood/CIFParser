package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

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
  public Character convert(String raw) {
    return DefaultCharConverter.getInstance().apply(raw);
  }
}
