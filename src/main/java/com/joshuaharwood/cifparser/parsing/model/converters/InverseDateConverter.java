package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class InverseDateConverter {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyMMdd");

  private InverseDateConverter() {
  }

  public static Optional<LocalDate> convert(String input) {
    if (input == null || input.isBlank()) {
      return Optional.empty();
    }

    if (input.length() != 6) {
      throw new IllegalArgumentException("Dates must be 6 digits.");
    }

    return Optional.of(LocalDate.parse(input, DATE_FORMAT));
  }
}
