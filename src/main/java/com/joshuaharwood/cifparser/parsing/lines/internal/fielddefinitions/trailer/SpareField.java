package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class SpareField implements TrailerField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  SpareField() {
  }

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 78;
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
    return "SpareField[]";
  }

}
