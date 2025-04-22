package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record SpareField() implements HeaderField<String> {

  @Override
  public int startIndex() {
    return 60;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 20;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}
