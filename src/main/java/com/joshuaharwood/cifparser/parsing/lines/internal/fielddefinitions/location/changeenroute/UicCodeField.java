package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record UicCodeField() implements ChangeEnRouteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 62;
  }

  @Override
  public String name() {
    return "UIC_CODE";
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