package com.joshuaharwood.cifparser.parsing.lines.internal;

import java.util.Map;

public class RequiredPropertyMissingException extends RuntimeException {

  public RequiredPropertyMissingException(String fieldName, String record, Map<?, ?> parsedValues) {
    super(
        "Failed to parse as a required CIF field was blank or null. [Field name: %s] [Record: %s] [Parsed values: %s]".formatted(
            fieldName, record, parsedValues));
  }
}
