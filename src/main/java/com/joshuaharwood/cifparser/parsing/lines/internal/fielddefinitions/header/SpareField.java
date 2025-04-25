package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

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
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}
