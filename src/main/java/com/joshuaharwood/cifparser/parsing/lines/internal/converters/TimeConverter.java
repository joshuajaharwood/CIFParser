package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TimeConverter {

  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HHmm");

  private TimeConverter() {
  }

  public static Optional<LocalTime> convert(String input) {
    if (input == null || input.isBlank()) {
      return Optional.empty();
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 4) {
      throw new IllegalArgumentException("Time input must be 4 digits.");
    }

    return Optional.of(LocalTime.parse(trimmed, TIME_FORMAT));
  }
}
