package com.joshuaharwood.cifparser.parsing.lines.internal.literals;

import com.google.common.collect.ImmutableSet;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.DuplicateLiteralException;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.UnknownLiteralException;
import java.util.EnumSet;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiteralLookup {

  private static final Logger logger = LoggerFactory.getLogger(LiteralLookup.class);

  private LiteralLookup() {
  }

  @Nullable
  public static <T extends Enum<T> & Literal> T lookup(Class<T> clazz, @Nullable String literal) {
    logger.debug("Attempting to lookup literal. [Class: {}] [Literal: {}]",
      clazz.getSimpleName(),
      literal);

    // We can short-circuit here...
    if (literal == null) {
      logger.debug("Literal was null. [Class: {}]", clazz.getSimpleName());
      return null;
    }

    if (literal.isBlank()) {
      logger.debug("Literal was blank. [Class: {}]", clazz.getSimpleName());
      return null;
    }

    var matches = EnumSet.allOf(clazz)
      .stream()
      .filter(e -> e.getLiteral() != null)
      .filter(e -> literal.toUpperCase().trim().equals(e.getLiteral().toUpperCase().trim()))
      .toList();

    if (matches.isEmpty()) {
      throw new UnknownLiteralException(clazz, literal);
    }

    if (matches.size() > 1) {
      throw new DuplicateLiteralException(clazz, literal, matches);
    }

    final var match = matches.getFirst();

    logger.debug("Matched literal. [Literal: {}]", match);

    return match;
  }

  public static <T extends Enum<T> & Literal> ImmutableSet<T> lookupSet(Class<T> clazz,
    @Nullable String s) {
    if (s == null || s.isBlank()) {
      return ImmutableSet.of();
    }

    return EnumSet.allOf(clazz)
      .stream()
      .filter(t -> t.getLiteral() != null)
      .filter(t -> s.equals(t.getLiteral()))
      .collect(ImmutableSet.toImmutableSet());
  }
}
