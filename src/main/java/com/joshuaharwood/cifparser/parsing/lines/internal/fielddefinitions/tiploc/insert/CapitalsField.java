package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import java.util.Optional;
import java.util.function.Function;

public record CapitalsField() implements TiplocInsertField<Optional<Byte>> {

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "CAPITALS";
  }

  @Override
  public int length() {
    return 2;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, Optional<Byte>> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return Optional.empty();
      }
      try {
        return Optional.of(Byte.parseByte(s.trim()));
      } catch (NumberFormatException e) {
        return Optional.empty();
      }
    };
  }
}