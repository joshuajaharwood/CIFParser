package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

public record ConnectIndicatorField() implements BasicScheduleField<Character> {

  private static final DefaultCharConverter CONVERTER = DefaultCharConverter.getInstance();

  @Override
  public int startIndex() {
    return 69;
  }

  @Override
  public String name() {
    return "CONNECT_INDICATOR";
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
    return CONVERTER.apply(raw);
  }
}
