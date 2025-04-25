package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record SpareField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 79;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 1;
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