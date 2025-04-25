package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record NlcField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 11;
  }

  @Override
  public String name() {
    return "NLC";
  }

  @Override
  public int length() {
    return 6;
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