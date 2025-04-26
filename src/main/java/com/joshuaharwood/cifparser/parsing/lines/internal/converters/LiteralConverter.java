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
    LOG.debug("Attempting to lookup literal. [Class: {}] [Literal: {}]",
      literalClass.getSimpleName(),
      input);

    // We can short-circuit here...
    
    //fixme: this should probably throw - we shouldn't be allowing empty collections here but handle
    //  them earlier?
    if (input.isBlank()) {
      LOG.debug("Literal was blank. [Class: {}]", literalClass.getSimpleName());
//      throw new IllegalArgumentException("String literals c")
      return null;
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
