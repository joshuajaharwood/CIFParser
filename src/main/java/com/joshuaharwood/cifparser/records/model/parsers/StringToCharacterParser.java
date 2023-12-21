package com.joshuaharwood.cifparser.records.model.parsers;

import java.util.Objects;
import java.util.Optional;

public class StringToCharacterParser {

  private StringToCharacterParser() {
  }

  public static Optional<Character> parseStringToCharacter(String s) {
    Objects.requireNonNull(s);

    if (s.isBlank()) {
      return Optional.empty();
    }

    if (s.length() > 1) {
      throw new IllegalArgumentException("Given string was longer than one character.");
    }

    return Optional.of(s.charAt(0));
  }
}
