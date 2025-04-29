package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

public final class RequiredPropertyMissingException extends CifLineParserException {

  public RequiredPropertyMissingException(String fieldName) {
    super("Failed to parse as a required CIF field was not populated. [Field name: %s]".formatted(fieldName));
  }
}
