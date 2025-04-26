package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import com.google.common.collect.ImmutableSet;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Literal;
import java.util.EnumSet;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public class LiteralSetConverter<T extends Enum<T> & Literal> implements Converter<Set<T>> {

  private final Class<T> literalClass;

  private LiteralSetConverter(Class<T> literalClass) {
    this.literalClass = literalClass;
  }

  public static <T extends Enum<T> & Literal> LiteralSetConverter<T> getInstance(Class<T> clazz) {
    return new LiteralSetConverter<>(clazz);
  }

  @Override
  @NonNull
  public Set<T> apply(String input) {
    if (input.isBlank()) {
      return ImmutableSet.of();
    }

    return EnumSet.allOf(literalClass)
      .stream()
      .filter(t -> t.getLiteral() != null)
      .filter(t -> input.equals(t.getLiteral()))
      .collect(ImmutableSet.toImmutableSet());
  }
}
