package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record OperatingCharacteristicsField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 40;
  }

  @Override
  public String name() {
    return "OPERATING_CHARACTERISTICS";
  }

  @Override
  public int length() {
    return 6;
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