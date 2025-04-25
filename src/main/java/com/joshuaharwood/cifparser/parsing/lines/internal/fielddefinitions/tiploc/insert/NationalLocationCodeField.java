package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record NationalLocationCodeField() implements TiplocInsertField<String> {

  @Override
  public int startIndex() {
    return 11;
  }

  @Override
  public String name() {
    return "NATIONAL_LOCATION_CODE";
  }

  @Override
  public int length() {
    return 6;
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