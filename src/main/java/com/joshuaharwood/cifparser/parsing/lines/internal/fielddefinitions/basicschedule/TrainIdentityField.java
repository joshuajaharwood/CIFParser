package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class TrainIdentityField implements BasicScheduleField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  TrainIdentityField() {
  }

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
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "TrainIdentityField[]";
  }

}
