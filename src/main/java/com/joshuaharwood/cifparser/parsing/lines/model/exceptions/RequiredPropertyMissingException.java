package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

import java.util.Map;

public final class RequiredPropertyMissingException extends CifLineParserException {

  public RequiredPropertyMissingException(String fieldName, Map<?, String> parsedValues) {
    super(
      "Failed to parse as a required CIF field was null. [Field name: %s] [Parsed values: %s]".formatted(
        fieldName,
        parsedValues));
  }
}
