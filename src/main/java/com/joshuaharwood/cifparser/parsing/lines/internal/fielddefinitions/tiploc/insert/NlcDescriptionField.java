package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class NlcDescriptionField implements TiplocInsertField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  NlcDescriptionField() {
  }

  @Override
  public int startIndex() {
    return 56;
  }

  @Override
  public String name() {
    return "NLC_DESCRIPTION";
  }

  @Override
  public int length() {
    return 16;
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
    return "NlcDescriptionField[]";
  }

}