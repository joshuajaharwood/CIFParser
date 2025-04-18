package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_TIME;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class TimeConverterTest {

  @Test
  void parseGoodTimeReturnsCorrectOptional() {
    assertThat(TimeConverter.apply("2359"))
      .get(LOCAL_TIME)
      .hasHour(23)
      .hasMinute(59)
      .hasSecond(0)
      .hasNano(0);
  }

  @Test
  void parseNullTimeReturnsEmptyOptional() {
    assertThat(TimeConverter.apply(null)).isEmpty();
  }

  @Test
  void parseInvalidTimeThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> TimeConverter.apply(
      "2559"));
  }

  @Test
  void parseTooShortDateThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> TimeConverter.apply("120"))
      .withMessage("Time input must be 4 digits.");
  }
}