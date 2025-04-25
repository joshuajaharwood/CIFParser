package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record StanoxField() implements TiplocAmendField<Integer> {

  @Override
  public int startIndex() {
    return 44;
  }

  @Override
  public String name() {
    return "STANOX";
  }

  @Override
  public int length() {
    return 5;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, Integer> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return null;
      }
      return Integer.valueOf(s);
    };
  }
}