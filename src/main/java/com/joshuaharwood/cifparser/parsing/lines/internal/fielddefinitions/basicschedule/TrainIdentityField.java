package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.NOOP_CONVERTER;

import java.util.function.Function;

public record TrainIdentityField() implements BasicScheduleField<String> {

  @Override
  public int order() {
    return 10;
  }

  @Override
  public String name() {
    return "TRAIN_IDENTITY";
  }

  @Override
  public int length() {
    return 4;
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
