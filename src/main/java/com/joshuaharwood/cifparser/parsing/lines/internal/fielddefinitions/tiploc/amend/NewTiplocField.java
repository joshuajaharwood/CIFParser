package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record NewTiplocField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 72;
  }

  @Override
  public String name() {
    return "NEW_TIPLOC";
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
  public Function<String, String> converter() {
    return Function.identity();
  }
}