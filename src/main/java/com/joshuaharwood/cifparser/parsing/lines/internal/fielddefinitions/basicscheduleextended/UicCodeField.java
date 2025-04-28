package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class UicCodeField implements BasicScheduleExtendedField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  UicCodeField() {
  }

  @Override
  public int startIndex() {
    return 6;
  }

  @Override
  public String name() {
    return "UIC_CODE";
  }

  @Override
  public int length() {
    return 5;
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
  public String toString() {
    return "UicCodeField[]";
  }
}