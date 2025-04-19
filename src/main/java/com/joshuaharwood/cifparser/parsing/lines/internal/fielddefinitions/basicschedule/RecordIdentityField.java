package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.NOOP_CONVERTER;

import java.util.function.Function;

public record RecordIdentityField() implements BasicScheduleField<String> {
  @Override
  public int startIndex() {
    return 0;
  }

  @Override
  public String name() {
    return "RECORD_IDENTITY";
  }

  @Override
  public int length() {
    return 2;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, String> converter() {
    return NOOP_CONVERTER;
  }
}
