package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record LocationField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "LOCATION";
  }

  @Override
  public int length() {
    return 8;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}