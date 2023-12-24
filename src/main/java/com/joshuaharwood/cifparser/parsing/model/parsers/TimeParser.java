package com.joshuaharwood.cifparser.parsing.model.parsers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeParser {

  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HHmm");

  private TimeParser() {
  }

  public static LocalTime parse(String input) {
    return LocalTime.parse(input, TIME_FORMAT);
  }
}
