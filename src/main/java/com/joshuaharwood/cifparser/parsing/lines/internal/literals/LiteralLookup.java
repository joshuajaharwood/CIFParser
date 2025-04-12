package com.joshuaharwood.cifparser.parsing.lines.internal.literals;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public class LiteralLookup {

  private LiteralLookup() {
  }

  public static <T extends Enum<T> & Literal> Optional<T> lookup(Class<T> clazz,
    @Nullable String literal) {
    Objects.requireNonNull(clazz);

    if (literal == null || literal.isBlank()) {
      return Optional.empty();
    }

    var foundEnumValue = EnumSet.allOf(clazz)
      .stream()
      .filter(e -> e.getLiteral() != null)
      .filter(e -> literal.toUpperCase().trim().equals(e.getLiteral()))
      .findFirst();

    if (foundEnumValue.isPresent()) {
      return foundEnumValue;
    } else {
      throw new IllegalArgumentException(
        "Failed to map String for given Literal. [String: %s] [Enum: %s]".formatted(literal,
          clazz.getSimpleName()));
    }
  }

  public static <T extends Enum<T> & Literal> Set<T> lookupCollection(Class<T> clazz,
    @Nullable String s) {
    if (s == null || s.isBlank()) {
      return Collections.emptySet();
    }

    Set<T> set = EnumSet.noneOf(clazz);

    s.trim()
      .chars()
      .forEachOrdered(ch -> lookup(clazz, String.valueOf((char) ch)).ifPresent(set::add));

    return Collections.unmodifiableSet(set);
  }
}
