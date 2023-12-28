package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class TimeConverterTest {

  @Test
  void parseDate() {
    assertThat(TimeConverter.convert("2359")).hasHour(23).hasMinute(59).hasSecond(0).hasNano(0);
  }

  @Test
  void parseNullDateThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatNullPointerException().isThrownBy(() -> TimeConverter.convert(null));
  }

  @Test
  void parseInvalidTimeThrowsJavaTimeException() {
    //noinspection ResultOfMethodCallIgnored
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> TimeConverter.convert(
        "2559"));
  }
}