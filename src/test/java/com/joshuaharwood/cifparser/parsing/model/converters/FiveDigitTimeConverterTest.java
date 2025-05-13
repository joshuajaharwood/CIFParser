package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class FiveDigitTimeConverterTest {
  private static final FiveDigitTimeConverter FIVE_DIGIT_TIME_CONVERTER = FiveDigitTimeConverter.getInstance(); 

  @Test
  public void convertsEmptyPadded5DigitInputSuccessfully() {
    assertThat(FIVE_DIGIT_TIME_CONVERTER.apply("1704 "))
        .hasHour(17)
        .hasMinute(4)
        .hasSecond(0);
  }

  @Test
  public void convertsNonPadded5DigitInputSuccessfully() {
    assertThat(FIVE_DIGIT_TIME_CONVERTER.apply("1704"))
        .hasHour(17)
        .hasMinute(4)
        .hasSecond(0);
  }

  @Test
  public void convertsHPadded5DigitInputSuccessfully() {
    assertThat(FIVE_DIGIT_TIME_CONVERTER.apply("1704H"))
        .hasHour(17)
        .hasMinute(4)
        .hasSecond(30);
  }

  @Test
  public void convertingTimeStringWithUnknownPaddingCharacterThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> FIVE_DIGIT_TIME_CONVERTER.apply("1704X"))
        .withMessage("Unrecognised character appended to 4-digit time. [Input: 1704X]");
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  public void convertingNullThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> FIVE_DIGIT_TIME_CONVERTER.apply(null)).withMessage("Time must not be null.");
  }

  @Test
  public void convertingOversizedTimeStringThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> FIVE_DIGIT_TIME_CONVERTER.apply("123456"))
        .withMessage("Input must be 4 or 5 digits long. [Input: 123456]");
  }

  @Test
  public void convertingUndersizedTimeStringThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> FIVE_DIGIT_TIME_CONVERTER.apply("12"))
        .withMessage("Input must be 4 or 5 digits long. [Input: 12]");
  }

  @Test
  public void convertingInvalidTimeStringThrowsDateTimeParseException() {
    assertThatExceptionOfType(DateTimeParseException.class).isThrownBy(() -> FIVE_DIGIT_TIME_CONVERTER.apply(
        "9999H"));
  }
}