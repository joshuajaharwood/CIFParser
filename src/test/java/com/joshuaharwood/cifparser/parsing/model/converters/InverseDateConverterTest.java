//package com.joshuaharwood.cifparser.parsing.model.converters;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;
//
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
//import java.time.Month;
//import java.time.format.DateTimeParseException;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//class InverseDateConverterTest {
//
//  @Test
//  void parseGoodDateReturnsCorrectOptional() {
//    assertThat(InverseDateConverter.apply("631110"))
//        .get(LOCAL_DATE)
//        .hasDayOfMonth(10)
//        .hasMonth(Month.NOVEMBER)
//        .hasYear(2063);
//  }
//
//  @Test
//  void parseNullDateReturnsEmptyOptional() {
//    assertThat(InverseDateConverter.apply(null)).isEmpty();
//  }
//
//  @Test
//  void parseInvalidDateThrowsJavaTimeException() {
//    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> InverseDateConverter.apply(
//        "011301"));
//  }
//
//  @Test
//  void parseTooShortDateThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException()
//        .isThrownBy(() -> InverseDateConverter.apply("01010"))
//        .withMessage("Date input must be 6 digits.");
//    
//    
//    
//    assertThat(List.of(1, 2, 3)).containsExactly(1, 2, 3);
//  }
//}