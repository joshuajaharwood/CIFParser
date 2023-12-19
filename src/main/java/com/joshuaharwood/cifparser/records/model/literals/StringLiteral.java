package com.joshuaharwood.cifparser.records.model.literals;

import java.util.Objects;
import java.util.Optional;

public interface StringLiteral {

  static <U extends Enum<U> & StringLiteral> Optional<U> parseLiteral(Class<U> enumType, String s) {
    Objects.requireNonNull(enumType);

    if (s == null || s.isBlank()) {
      return Optional.empty();
    }

    for (U constant : enumType.getEnumConstants()) {
      if (s.toUpperCase().trim().equals(constant.getLiteral())) {
        return Optional.of(constant);
      }
    }

    throw new IllegalArgumentException(
        "Failed to map String for given StringLiteral. [String: %s] [Enum: %s]".formatted(s,
            enumType.getSimpleName()));
  }

  String getLiteral();
}
