package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.jspecify.annotations.Nullable;

public class InverseDateConverter {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyMMdd");

  private InverseDateConverter() {
  }

  @Nullable
  public static LocalDate convert(@Nullable String input) {
    if (input == null || input.isBlank()) {
      return null;
    }

    if (input.length() != 6) {
      throw new IllegalArgumentException("Date input must be 6 digits.");
    }

    return LocalDate.parse(input, DATE_FORMAT);
  }
}
