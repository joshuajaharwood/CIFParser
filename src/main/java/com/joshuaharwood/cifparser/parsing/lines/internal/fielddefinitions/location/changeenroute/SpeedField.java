package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record SpeedField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 37;
  }

  @Override
  public String name() {
    return "SPEED";
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
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}