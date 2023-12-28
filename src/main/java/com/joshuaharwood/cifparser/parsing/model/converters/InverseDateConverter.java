package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InverseDateConverter {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyMMdd");

  private InverseDateConverter() {
  }

  public static LocalDate convert(String input) {
    return LocalDate.parse(input, DATE_FORMAT);
  }
}
