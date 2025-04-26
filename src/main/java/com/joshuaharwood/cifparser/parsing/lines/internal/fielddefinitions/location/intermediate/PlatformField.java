package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record PlatformField() implements IntermediateLocationField<String> {
  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 33;
  }

  @Override
  public String name() {
    return "PLATFORM";
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