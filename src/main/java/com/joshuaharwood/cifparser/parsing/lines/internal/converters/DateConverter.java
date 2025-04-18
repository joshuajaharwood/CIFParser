package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateConverter implements Converter<Optional<LocalDate>> {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddMMyy");

  private static final DateConverter INSTANCE = new DateConverter();

  private DateConverter() {
  }
  
  public static DateConverter getInstance() {
    return INSTANCE;
  }

  public Optional<LocalDate> apply(String input) {
    if (input.isBlank()) {
      return Optional.empty();
    }

    final String trimmed = input.trim();

    if (trimmed.length() != 6) {
      throw new IllegalArgumentException("Date input must be 6 digits.");
    }

    return Optional.of(LocalDate.parse(trimmed, DATE_FORMAT));
  }
}
