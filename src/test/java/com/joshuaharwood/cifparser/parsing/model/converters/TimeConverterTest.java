package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_TIME;

import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class TimeConverterTest {

  @Test
  void parseGoodTimeReturnsCorrectOptional() {
    assertThat(TimeConverter.convert("2359")).get(LOCAL_TIME)
                                             .hasHour(23)
                                             .hasMinute(59)
                                             .hasSecond(0)
                                             .hasNano(0);
  }

  @Test
  void parseNullTimeReturnsEmptyOptional() {
    assertThat(TimeConverter.convert(null)).isEmpty();
  }

  @Test
  void parseInvalidTimeThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> TimeConverter.convert(
        "2559"));
  }
}