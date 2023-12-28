package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddMMyy");

  private DateConverter() {
  }

  public static LocalDate convert(String input) {
    return LocalDate.parse(input, DATE_FORMAT);
  }
}
