package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record LineField() implements OriginLocationField<String> {
  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 22;
  }

  @Override
  public String name() {
    return "LINE";
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
}