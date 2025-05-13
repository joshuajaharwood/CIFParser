package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.Month;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class DateConverterTest {

  private static final DateConverter DATE_CONVERTER = DateConverter.getInstance();

  @Test
  void parseGoodDateReturnsCorrectLocalDate() {
    assertThat(DATE_CONVERTER.apply("221123")).hasDayOfMonth(22)
      .hasMonth(Month.NOVEMBER)
      .hasYear(2023);
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void parseNullDateThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> DATE_CONVERTER.apply(null))
      .withMessage("Date must not be null.");
  }

  @Test
  void parseInvalidDateThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> DATE_CONVERTER.apply(
      "011301"));
  }

  @Test
  void parseTooShortDateThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> DATE_CONVERTER.apply("01010"))
      .withMessage("Date input must be 6 digits.");
  }
}