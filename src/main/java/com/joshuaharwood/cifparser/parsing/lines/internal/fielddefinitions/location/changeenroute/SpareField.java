package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record SpareField() implements ChangeEnRouteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 75;
  }

  @Override
  public String name() {
    return "SPARE";
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
    return CONVERTER.apply(raw);
  }
}