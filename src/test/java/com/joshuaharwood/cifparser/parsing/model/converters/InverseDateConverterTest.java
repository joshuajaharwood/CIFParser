package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.junit.jupiter.api.Test;

class InverseDateConverterTest {

  private static final InverseDateConverter INVERSE_DATE_CONVERTER = InverseDateConverter.getInstance();

  @Test
  void parseGoodDateReturnsCorrectOptional() {
    assertThat(INVERSE_DATE_CONVERTER.apply("631110"))
      .hasDayOfMonth(10)
      .hasMonth(Month.NOVEMBER)
      .hasYear(2063);
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void parseNullDateThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> INVERSE_DATE_CONVERTER.apply(null)).withMessage("Date must not be null.");
  }

  @Test
  void parseInvalidDateThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> INVERSE_DATE_CONVERTER.apply(
      "011301"));
  }

  @Test
  void parseTooShortDateThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> INVERSE_DATE_CONVERTER.apply("01010"))
      .withMessage("Date input must be 6 digits.");

    assertThat(List.of(1, 2, 3)).containsExactly(1, 2, 3);
  }
}