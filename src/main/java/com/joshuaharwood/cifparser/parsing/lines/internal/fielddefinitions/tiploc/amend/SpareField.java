package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

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
  public Function<String, String> converter() {
    return Function.identity();
  }
}