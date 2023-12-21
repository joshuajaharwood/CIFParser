package com.joshuaharwood.cifparser.records.model.literals;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LiteralLookup {

  private LiteralLookup() {
  }

  public static <T extends Enum<T> & Literal> @NotNull Optional<T> lookup(@NotNull Class<T> clazz,
      @Nullable String literal) {
    Objects.requireNonNull(clazz);

    if (literal == null || literal.isBlank()) {
      return Optional.empty();
    }

    var foundEnumValue = EnumSet.allOf(clazz)
        .stream()
        .filter(e -> literal.toUpperCase().trim().equals(e.getLiteral()))
        .findFirst();

    if (foundEnumValue.isPresent()) {
      return foundEnumValue;
    } else {
      throw new IllegalArgumentException(
          "Failed to map String for given StringLiteral. [String: %s] [Enum: %s]".formatted(literal,
              clazz.getSimpleName()));
    }
  }
}
