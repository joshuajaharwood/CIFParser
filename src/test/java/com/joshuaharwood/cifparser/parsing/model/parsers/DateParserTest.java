package com.joshuaharwood.cifparser.parsing.model.parsers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.time.Month;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class DateParserTest {

  @Test
  void parseDate() {
    assertThat(DateParser.parse("221123")).hasDayOfMonth(22).hasMonth(Month.NOVEMBER).hasYear(2023);
  }

  @Test
  void parseNullDateThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatNullPointerException().isThrownBy(() -> DateParser.parse(null));
  }

  @Test
  void parseInvalidDateThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> DateParser.parse(
        "011301"));
  }
}