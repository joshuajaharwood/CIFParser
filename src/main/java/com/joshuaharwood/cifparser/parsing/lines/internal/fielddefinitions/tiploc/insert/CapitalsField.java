package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import java.util.Optional;

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
  public Optional<Byte> convert(String raw) {
    if (raw.isBlank()) {
      return Optional.empty();
    }
    try {
      return Optional.of(Byte.parseByte(raw.trim()));
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }
}