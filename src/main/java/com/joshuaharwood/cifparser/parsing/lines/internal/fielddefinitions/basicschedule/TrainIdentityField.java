package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

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
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}
