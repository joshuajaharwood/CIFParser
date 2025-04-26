package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.Literal;
import java.util.Collection;
import java.util.stream.Collectors;

public final class DuplicateLiteralException extends CifLineParserException {

  public <T extends Enum<T> & Literal> DuplicateLiteralException(Class<T> literalClass,
    String literal,
    Collection<T> matches) {
    super("""
      Found multiple matching enum literals for the given literal value and type.
      [Literal type: %s] [Literal value: %s] [Matches: %s]
      """.formatted(literalClass.getSimpleName(),
      literal,
      matches.stream().map(Enum::name).collect(Collectors.joining(", "))));
  }
}
