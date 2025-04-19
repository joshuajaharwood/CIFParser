//package com.joshuaharwood.cifparser.parsing.model.converters;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_TIME;
//
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
//import java.time.format.DateTimeParseException;
//import org.junit.jupiter.api.Test;
//
//class FiveDigitTimeConverterTest {
//
//  @Test
//  public void convertsEmptyPadded5DigitInputSuccessfully() {
//    assertThat(FiveDigitTimeConverter.apply("1704 "))
//        .get(LOCAL_TIME)
//        .hasHour(17)
//        .hasMinute(4)
//        .hasSecond(0);
//  }
//
//  @Test
//  public void convertsNonPadded5DigitInputSuccessfully() {
//    assertThat(FiveDigitTimeConverter.apply("1704"))
//        .get(LOCAL_TIME)
//        .hasHour(17)
//        .hasMinute(4)
//        .hasSecond(0);
//  }
//
//  @Test
//  public void convertsHPadded5DigitInputSuccessfully() {
//    assertThat(FiveDigitTimeConverter.apply("1704H"))
//        .get(LOCAL_TIME)
//        .hasHour(17)
//        .hasMinute(4)
//        .hasSecond(30);
//  }
//
//  @Test
//  public void convertingTimeStringWithUnknownPaddingCharacterThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException()
//        .isThrownBy(() -> FiveDigitTimeConverter.apply("1704X"))
//        .withMessageContaining("Unknown character appended to 5-digit time. [Input: 1704X]");
//  }
//
//  @Test
//  public void convertingNullReturnsEmptyOptional() {
//    assertThat(FiveDigitTimeConverter.apply(null)).isEmpty();
//  }
//
//  @Test
//  public void convertingOversizedTimeStringThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException()
//        .isThrownBy(() -> FiveDigitTimeConverter.apply("123456"))
//        .withMessageContaining("Passed in time Strings must be 5 digits. [Input: 123456]");
//  }
//
//  @Test
//  public void convertingUndersizedTimeStringThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException()
//        .isThrownBy(() -> FiveDigitTimeConverter.apply("12"))
//        .withMessageContaining("Passed in time Strings must be 5 digits. [Input: 12]");
//  }
//
//  @Test
//  public void convertingInvalidTimeStringThrowsDateTimeParseException() {
//    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> FiveDigitTimeConverter.apply(
//        "9999H"));
//  }
//}