package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter implements Converter<LocalDate> {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddMMyy");

  private static final DateConverter INSTANCE = new DateConverter();

  private DateConverter() {
  }

  public static DateConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public LocalDate apply(String input) {
    if (input.isBlank()) {
      throw new IllegalArgumentException("Input cannot be blank string");
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 6) {
      throw new IllegalArgumentException("Date input must be 6 digits.");
    }

    return LocalDate.parse(trimmed, DATE_FORMAT);
  }
}
