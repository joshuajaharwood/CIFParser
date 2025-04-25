package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record NlcCheckCharacterField() implements TiplocAmendField<Character> {

  @Override
  public int startIndex() {
    return 17;
  }

  @Override
  public String name() {
    return "NLC_CHECK_CHARACTER";
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
  public Function<String, Character> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return null;
      }
      if (s.length() != 1) {
        throw new IllegalArgumentException("Given string was longer than one character.");
      }
      return s.charAt(0);
    };
  }
}