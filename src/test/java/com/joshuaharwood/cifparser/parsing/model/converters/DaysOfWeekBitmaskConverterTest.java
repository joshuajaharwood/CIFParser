package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;

class DaysOfWeekBitmaskConverterTest {

  private static final DaysOfWeekBitmaskConverter DAYS_OF_WEEK_BITMASK_CONVERTER = DaysOfWeekBitmaskConverter.getInstance();

  @Test
  void convertValidBitmask() {
    assertThat(DAYS_OF_WEEK_BITMASK_CONVERTER.apply("0110011")).containsOnly(DayOfWeek.TUESDAY,
      DayOfWeek.WEDNESDAY,
      DayOfWeek.SATURDAY,
      DayOfWeek.SUNDAY);
  }

  @Test
  void convertInvalidBitmaskWrongLength() {
    assertThatIllegalArgumentException().isThrownBy(() -> DAYS_OF_WEEK_BITMASK_CONVERTER.apply("0110"))
      .withMessage("Days-of-week bitmask must be 7 binary digits.");
  }

  @Test
  void convertInvalidBitmaskBadBit() {
    assertThatIllegalArgumentException().isThrownBy(() -> DAYS_OF_WEEK_BITMASK_CONVERTER.apply(
      "0110211")).withMessage("Illegal character in bitmask. [Bitmask: 0110211] [Index: 4]");
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void convertNullBitmaskThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> DAYS_OF_WEEK_BITMASK_CONVERTER.apply(null))
      .withMessage("Days-of-week bitmask must not be null.");
  }
}