package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

import java.time.DayOfWeek;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.Test;

class DaysOfWeekBitmaskConverterTest {

  @Test
  void convertValidBitmask() {
    assertThat(DaysOfWeekBitmaskConverter.convert("0110011")).get(map(DayOfWeek.class,
                                                                 Boolean.class))
                                                             .containsExactly(entry(DayOfWeek.MONDAY,
                                                                     false),
                                                                 entry(DayOfWeek.TUESDAY, true),
                                                                 entry(DayOfWeek.WEDNESDAY, true),
                                                                 entry(DayOfWeek.THURSDAY, false),
                                                                 entry(DayOfWeek.FRIDAY, false),
                                                                 entry(DayOfWeek.SATURDAY, true),
                                                                 entry(DayOfWeek.SUNDAY, true));
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