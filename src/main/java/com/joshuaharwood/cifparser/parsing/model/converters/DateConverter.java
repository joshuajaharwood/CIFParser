package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class DateConverter {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddMMyy");

  private DateConverter() {
  }

  public static Optional<LocalDate> convert(String input) {
    if (input == null || input.isBlank()) {
      return Optional.empty();
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 6) {
      throw new IllegalArgumentException("Date input must be 6 digits.");
    }

    return Optional.of(LocalDate.parse(trimmed, DATE_FORMAT));
  }
}
