package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record TrainUidField() implements BasicScheduleField<String> {

  @Override
  public int startIndex() {
    return 3;
  }

  @Override
  public String name() {
    return "TRAIN_UID";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}
