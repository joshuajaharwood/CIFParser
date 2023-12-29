package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;

import java.time.Month;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class InverseDateConverterTest {

  @Test
  void parseGoodDateReturnsCorrectOptional() {
    assertThat(InverseDateConverter.convert("631110"))
        .get(LOCAL_DATE)
        .hasDayOfMonth(10)
        .hasMonth(Month.NOVEMBER)
        .hasYear(2063);
  }

  @Test
  void parseNullDateReturnsEmptyOptional() {
    assertThat(InverseDateConverter.convert(null)).isEmpty();
  }

  @Test
  void parseInvalidDateThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> DateConverter.convert(
        "011301"));
  }

  @Test
  void parseTooShortDateThrowsSomething() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> InverseDateConverter.convert("01010"))
        .withMessage("Date input must be 6 digits.");
  }
}