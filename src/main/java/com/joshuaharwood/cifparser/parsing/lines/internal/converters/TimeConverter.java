package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter implements Converter<LocalTime> {

  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HHmm");

  private static final TimeConverter INSTANCE = new TimeConverter();

  private TimeConverter() {
  }

  public static TimeConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public LocalTime apply(String input) {
    if (input.isBlank()) {
      throw new IllegalArgumentException("Input cannot be blank string.");
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 4) {
      throw new IllegalArgumentException("Time input must be 4 digits.");
    }

    return LocalTime.parse(trimmed, TIME_FORMAT);
  }
}
