package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class TimeConverterTest {

  private static final TimeConverter TIME_CONVERTER = TimeConverter.getInstance();

  @Test
  void parseGoodTimeReturnsCorrectLocalTime() {
    assertThat(TIME_CONVERTER.apply("2359")).hasHour(23).hasMinute(59).hasSecond(0).hasNano(0);
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void parseNullTimeThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> TIME_CONVERTER.apply(null))
      .withMessage("Time must not be null.");
  }

  @Test
  void parseInvalidTimeThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> TIME_CONVERTER.apply(
      "2559"));
  }

  @Test
  void parseTooShortDateThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> TIME_CONVERTER.apply("120"))
      .withMessage("Time input must be 4 digits.");
  }
}