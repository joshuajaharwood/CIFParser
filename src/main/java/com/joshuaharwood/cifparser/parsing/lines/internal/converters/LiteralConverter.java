package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
import java.util.Objects;

public class LiteralConverter<T extends Enum<T> & Literal> implements Converter<T> {

  private final Class<T> literalClass;

  private LiteralConverter(Class<T> literalClass) {
    this.literalClass = literalClass;
  }

  public static <T extends Enum<T> & Literal> LiteralConverter<T> getInstance(Class<T> clazz) {
    return new LiteralConverter<>(clazz);
  }

  @Override
  public T apply(String input) {
    return Objects.requireNonNull(LiteralLookup.lookup(literalClass, input));
  }
}
