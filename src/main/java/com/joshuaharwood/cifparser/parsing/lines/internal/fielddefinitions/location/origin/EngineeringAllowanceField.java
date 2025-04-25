package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record EngineeringAllowanceField() implements OriginLocationField<String> {

  @Override
  public int startIndex() {
    return 25;
  }

  @Override
  public String name() {
    return "ENGINEERING_ALLOWANCE";
  }

  @Override
  public int length() {
    return 2;
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