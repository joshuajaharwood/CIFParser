package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;
import java.util.function.Function;

public record ConnectIndicatorField() implements BasicScheduleField<Character> {
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
  public Function<String, Character> converter() {
    return DefaultCharConverter.getInstance();
  }
}
