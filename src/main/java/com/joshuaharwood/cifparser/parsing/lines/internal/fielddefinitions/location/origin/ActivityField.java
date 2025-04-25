package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record ActivityField() implements OriginLocationField<String> {

  @Override
  public int startIndex() {
    return 29;
  }

  @Override
  public String name() {
    return "ACTIVITY";
  }

  @Override
  public int length() {
    return 12;
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