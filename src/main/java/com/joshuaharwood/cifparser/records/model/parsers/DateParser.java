package com.joshuaharwood.cifparser.records.model.parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddMMyy");

  private DateParser() {
  }

  public static LocalDate parse(String input) {
    return LocalDate.parse(input, DATE_FORMAT);
  }
}
