package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record BusinessSectorField() implements ChangeEnRouteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  @Override
  public int startIndex() {
    return 29;
  }

  @Override
  public String name() {
    return "BUSINESS_SECTOR";
  }

  @Override
  public int length() {
    return 1;
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