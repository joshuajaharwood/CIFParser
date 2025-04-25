package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import java.util.Optional;
import java.util.function.Function;

public record NlcCheckCharacterField() implements TiplocInsertField<Optional<Character>> {

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
  public Function<String, Optional<Character>> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return Optional.empty();
      }
      return Optional.of(s.charAt(0));
    };
  }
}