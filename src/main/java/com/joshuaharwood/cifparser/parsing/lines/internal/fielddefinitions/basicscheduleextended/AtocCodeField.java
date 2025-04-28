package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class AtocCodeField implements BasicScheduleExtendedField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  AtocCodeField() {
  }

  @Override
  public int startIndex() {
    return 11;
  }

  @Override
  public String name() {
    return "ATOC_CODE";
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
  public String convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "AtocCodeField[]";
  }

}
