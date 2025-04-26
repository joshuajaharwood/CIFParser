package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record RetailServiceIdField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 67;
  }

  @Override
  public String name() {
    return "RETAIL_SERVICE_ID";
  }

  @Override
  public int length() {
    return 8;
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