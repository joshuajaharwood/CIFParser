package com.joshuaharwood.cifparser.records.model.literals;

import java.util.Optional;

public interface StringLiteral {
  //FIXME: write tests for me!
  static <U extends Enum<U> & StringLiteral> Optional<U> parseLiteral(Class<U> enumType, String s) {
    if (enumType == null) {
      throw new IllegalArgumentException("Null type argument passed for enumType.");
    }

    if (s == null) {
      return Optional.empty();
    }

    for (U constant : enumType.getEnumConstants()) {
      if (s.toUpperCase().trim().equals(constant.getLiteral())) {
        return Optional.of(constant);
      }
    }

    return Optional.empty();
  }

  String getLiteral();
}
