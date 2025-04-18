package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TimeConverter implements Converter<Optional<LocalTime>> {

  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HHmm");

  private static final TimeConverter INSTANCE = new TimeConverter();

  private TimeConverter() {
  }

  public static TimeConverter getInstance() {
    return INSTANCE;
  }

  public Optional<LocalTime> apply(String input) {
    if (input.isBlank()) {
      return Optional.empty();
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 4) {
      throw new IllegalArgumentException("Time input must be 4 digits.");
    }

    return Optional.of(LocalTime.parse(trimmed, TIME_FORMAT));
  }
}
