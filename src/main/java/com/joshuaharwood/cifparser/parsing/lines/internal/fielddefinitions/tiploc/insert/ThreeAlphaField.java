package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class ThreeAlphaField implements TiplocInsertField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  ThreeAlphaField() {
  }

  @Override
  public int startIndex() {
    return 53;
  }

  @Override
  public String name() {
    return "THREE_ALPHA";
  }

  @Override
  public int length() {
    return 3;
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
    return "ThreeAlphaField[]";
  }

}