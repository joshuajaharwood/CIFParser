package com.joshuaharwood.cifparser.records.model.parsers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class TimeParserTest {

  @Test
  void parseDate() {
    assertThat(TimeParser.parse("2359")).hasHour(23).hasMinute(59).hasSecond(0).hasNano(0);
  }

  @Test
  void parseNullDateThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatNullPointerException().isThrownBy(() -> TimeParser.parse(null));
  }

  @Test
  void parseInvalidTimeThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> TimeParser.parse(
        "2559"));
  }
}