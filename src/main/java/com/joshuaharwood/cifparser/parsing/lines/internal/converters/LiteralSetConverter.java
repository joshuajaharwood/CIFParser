package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
import java.util.Objects;
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
    return LiteralLookup.lookupSet(literalClass, input);
  }
}
