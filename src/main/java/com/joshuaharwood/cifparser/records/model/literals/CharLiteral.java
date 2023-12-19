package com.joshuaharwood.cifparser.records.model.literals;

import java.util.Objects;
import java.util.Optional;

public interface CharLiteral {

  static <U extends Enum<U> & CharLiteral> Optional<U> parseLiteral(Class<U> enumType,
      Character c) {
    Objects.requireNonNull(enumType);

    if (c == null || Character.isWhitespace(c)) {
      return Optional.empty();
    }

    for (U constant : enumType.getEnumConstants()) {
      if (Character.toUpperCase(c) == constant.getLiteral()) {
        return Optional.of(constant);
      }
    }

    throw new IllegalArgumentException(
        "Failed to map character for given CharLiteral. [Character: %c] [Enum: %s]".formatted(c,
            enumType.getSimpleName()));
  }

  char getLiteral();
}
