package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.NOOP_CONVERTER;

import java.util.function.Function;

public record SpareField() implements BasicScheduleField<String> {
  @Override
  public int startIndex() {
    return 78;
  }

  @Override
  public String name() {
    return "SPARE";
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
  public Function<String, String> converter() {
    return NOOP_CONVERTER;
  }
}
