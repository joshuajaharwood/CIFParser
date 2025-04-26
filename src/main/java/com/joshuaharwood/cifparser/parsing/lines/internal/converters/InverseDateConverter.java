package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.jspecify.annotations.NonNull;

public class InverseDateConverter implements Converter<LocalDate> {

  private static final InverseDateConverter INSTANCE = new InverseDateConverter();

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyMMdd");

  private InverseDateConverter() {
  }

  public static InverseDateConverter getInstance() {
    return INSTANCE;
  }

  @Override
  @NonNull
  public LocalDate apply(String input) {
    if (input.length() != 6) {
      throw new IllegalArgumentException("Date input must be 6 digits.");
    }

    return LocalDate.parse(input, DATE_FORMAT);
  }
}
