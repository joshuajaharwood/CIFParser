package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.InstanceOfAssertFactories.collection;

import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;

class DaysOfWeekBitmaskConverterTest {

  @Test
  void convertValidBitmask() {
    assertThat(DaysOfWeekBitmaskConverter.convert("0110011")).get(collection(DayOfWeek.class))
                                                             .containsOnly(DayOfWeek.TUESDAY,
                                                                 DayOfWeek.WEDNESDAY,
                                                                 DayOfWeek.SATURDAY,
                                                                 DayOfWeek.SUNDAY);
  }

  @Test
  void convertInvalidBitmask() {
    assertThatIllegalArgumentException().isThrownBy(() -> DaysOfWeekBitmaskConverter.convert("0110"))
                                        .withMessage("Days-of-week bitmask must be 7 binary digits.");
  }

  @Test
  void convertNullBitmask() {
    assertThatNullPointerException().isThrownBy(() -> DaysOfWeekBitmaskConverter.convert(null))
                                    .withMessage("Days-of-week bitmask must not be null.");
  }
}