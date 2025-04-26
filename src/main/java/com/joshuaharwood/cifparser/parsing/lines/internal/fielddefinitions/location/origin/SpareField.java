package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record SpareField() implements OriginLocationField<String> {

  @Override
  public int startIndex() {
    return 43;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 37;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public String convert(String raw) {
    return CONVERTER.apply(raw);
  }
}