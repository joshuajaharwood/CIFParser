package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.Literal;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.DuplicateLiteralException;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.UnknownLiteralException;
import java.util.EnumSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiteralConverter<T extends Enum<T> & Literal> implements Converter<T> {

  private static final Logger LOG = LoggerFactory.getLogger(LiteralConverter.class);

  private final Class<T> literalClass;

  private LiteralConverter(Class<T> literalClass) {
    this.literalClass = literalClass;
  }

  public static <T extends Enum<T> & Literal> LiteralConverter<T> create(Class<T> clazz) {
    return new LiteralConverter<>(clazz);
  }

  @Override
  public T apply(String input) {
    LOG.debug("Looking up literal. [Class: {}] [Literal: {}]", literalClass.getSimpleName(), input);

    if (input.isBlank()) {
      throw new IllegalArgumentException("Literal string must not be blank.");
    }

    var matches = EnumSet.allOf(literalClass)
      .stream()
      .filter(e -> e.getLiteral() != null)
      .filter(e -> input.toUpperCase().trim().equals(e.getLiteral().toUpperCase().trim()))
      .toList();

    if (matches.isEmpty()) {
      throw new UnknownLiteralException(literalClass, input);
    }

    if (matches.size() > 1) {
      throw new DuplicateLiteralException(literalClass, input, matches);
    }

    final var match = matches.getFirst();

    LOG.debug("Matched literal. [Literal: {}]", match);

    return match;
  }
}
