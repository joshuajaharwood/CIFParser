package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record TiplocCodeField() implements TiplocInsertField<String> {

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "TIPLOC_CODE";
  }

  @Override
  public int length() {
    return 7;
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