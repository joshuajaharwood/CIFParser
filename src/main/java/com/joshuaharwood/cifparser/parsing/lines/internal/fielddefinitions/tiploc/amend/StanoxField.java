package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record StanoxField() implements TiplocAmendField<String> {
  private static final DefaultStringConverter DEFAULT_STRING_CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 44;
  }

  @Override
  public String name() {
    return "STANOX";
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
    return DEFAULT_STRING_CONVERTER.apply(raw);
  }
}