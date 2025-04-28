package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class TrainUidField implements BasicScheduleField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  TrainUidField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "TrainUidField[]";
  }

}
