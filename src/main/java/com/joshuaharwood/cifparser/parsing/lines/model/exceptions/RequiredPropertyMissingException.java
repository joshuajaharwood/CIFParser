package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

import java.util.Map;

public class RequiredPropertyMissingException extends RuntimeException {

  public RequiredPropertyMissingException(ParserPropertyMetadata metadata) {
    super(
      "Failed to parse as a required CIF field was null. [Field name: %s] [Record: %s] [Parsed values: %s] [Target class: %s]".formatted(
        metadata.fieldName(),
        metadata.record(),
        metadata.parsedValues()));
  }

  public record ParserPropertyMetadata(String fieldName, String record, Map<?, ?> parsedValues) {

  }
}
