package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.delete;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record SpareField() implements TiplocDeleteField<String> {

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 71;
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