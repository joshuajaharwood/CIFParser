package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import java.util.Optional;
import java.util.function.Function;

public record StanoxField() implements TiplocInsertField<Optional<Integer>> {

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
  public Function<String, Optional<Integer>> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return Optional.empty();
      }
      try {
        return Optional.of(Integer.valueOf(s.trim()));
      } catch (NumberFormatException e) {
        return Optional.empty();
      }
    };
  }
}