package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

public sealed class CifLineParserException extends RuntimeException permits
  RequiredPropertyMissingException, UnknownLiteralException, DuplicateLiteralException {

  public CifLineParserException(String message, Exception e) {
    super(message, e);
  }

  public CifLineParserException(String message) {
    super(message);
  }
}
