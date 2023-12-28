package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HHmm");

  private TimeConverter() {
  }

  public static LocalTime convert(String input) {
    return LocalTime.parse(input, TIME_FORMAT);
  }
}
