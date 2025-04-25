package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record TiplocCodeField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "TIPLOC_CODE";
  }

  @Override
  public int length() {
    return 7;
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