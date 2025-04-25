package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record ThreeAlphaCodeField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 53;
  }

  @Override
  public String name() {
    return "THREE_ALPHA_CODE";
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
    return Function.identity();
  }
}