package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class RetailServiceIdField implements BasicScheduleExtendedField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  RetailServiceIdField() {
  }

  @Override
  public int startIndex() {
    return 14;
  }

  @Override
  public String name() {
    return "RETAIL_SERVICE_ID";
  }

  @Override
  public int length() {
    return 8;
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
    return "RetailServiceIdField[]";
  }

}
