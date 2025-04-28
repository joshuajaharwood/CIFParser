package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.Literal;

public final class UnknownLiteralException extends CifLineParserException {

  public <T extends Literal> UnknownLiteralException(Class<T> literalClass, String literal) {
    super(
      "Failed to find matching literal for given String. [Literal class: %s] [Literal string: %s]".formatted(
        literalClass.getSimpleName(),
        literal));
  }
}
