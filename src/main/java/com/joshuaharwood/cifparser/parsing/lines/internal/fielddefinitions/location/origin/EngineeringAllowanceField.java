package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class EngineeringAllowanceField implements OriginLocationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  EngineeringAllowanceField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "EngineeringAllowanceField[]";
  }

}