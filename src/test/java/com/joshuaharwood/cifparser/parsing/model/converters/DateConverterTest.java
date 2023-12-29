package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.InstanceOfAssertFactories.DATE;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;

import java.time.Month;
import java.time.format.DateTimeParseException;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.Test;

class DateConverterTest {

  @Test
  void parseGoodDateReturnsCorrectOptional() {
    assertThat(DateConverter.convert("221123"))
        .get(LOCAL_DATE)
        .hasDayOfMonth(22)
        .hasMonth(Month.NOVEMBER)
        .hasYear(2023);
  }

  @Test
  void parseNullDateReturnsEmptyOptional() {
    assertThat(DateConverter.convert(null)).isEmpty();
  }

  @Test
  void parseInvalidDateThrowsJavaTimeException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> DateConverter.convert(
        "011301"));
  }

  @Test
  void parseTooShortDateThrowsSomething() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> DateConverter.convert("01010"))
        .withMessage("Date input must be 6 digits.");
  }
}