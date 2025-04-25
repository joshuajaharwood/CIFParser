package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

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
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}