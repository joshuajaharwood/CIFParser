package com.joshuaharwood.cifparser.records.model;

import java.util.Optional;

public interface CharLiteral {

  static <U extends Enum<U> & CharLiteral> Optional<U> parseLiteral(Class<U> enumType,
      Character c) {
    if (enumType == null) {
      throw new IllegalArgumentException("Null type argument passed for enumType.");
    }

    if (c == null) {
      return Optional.empty();
    }

    for (U constant : enumType.getEnumConstants()) {
      if (Character.toUpperCase(c) == constant.getLiteral()) {
        return Optional.of(constant);
      }
    }

    return Optional.empty();
  }

  char getLiteral();
}
