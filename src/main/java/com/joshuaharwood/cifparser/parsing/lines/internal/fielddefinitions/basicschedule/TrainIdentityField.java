package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record TrainIdentityField() implements BasicScheduleField<String> {

  @Override
  public int startIndex() {
    return 32;
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
    return DefaultStringConverter.getInstance();
  }
}
