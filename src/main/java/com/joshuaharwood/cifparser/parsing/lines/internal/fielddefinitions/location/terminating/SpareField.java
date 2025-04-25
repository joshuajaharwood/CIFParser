package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record SpareField() implements TerminatingLocationField<String> {

  @Override
  public int startIndex() {
    return 37;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 43;
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