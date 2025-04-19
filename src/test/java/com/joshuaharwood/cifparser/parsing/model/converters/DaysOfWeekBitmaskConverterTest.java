//package com.joshuaharwood.cifparser.parsing.model.converters;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.assertj.core.api.Assertions.assertThatNullPointerException;
//
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
//import java.time.DayOfWeek;
//import org.junit.jupiter.api.Test;
//
//class DaysOfWeekBitmaskConverterTest {
//
//  @Test
//  void convertValidBitmask() {
//    assertThat(DaysOfWeekBitmaskConverter.apply("0110011")).containsOnly(DayOfWeek.TUESDAY,
//      DayOfWeek.WEDNESDAY,
//      DayOfWeek.SATURDAY,
//      DayOfWeek.SUNDAY);
//  }
//
//  @Test
//  void convertInvalidBitmaskWrongLength() {
//    assertThatIllegalArgumentException().isThrownBy(() -> DaysOfWeekBitmaskConverter.apply("0110"))
//      .withMessage("Days-of-week bitmask must be 7 binary digits.");
//  }
//
//  @Test
//  void convertInvalidBitmaskBadBit() {
//    assertThatIllegalArgumentException().isThrownBy(() -> DaysOfWeekBitmaskConverter.apply(
//      "0110211")).withMessage("Illegal character in bitmask. [Bitmask: 0110211] [Index: 4]");
//  }
//
//  @Test
//  void convertNullBitmask() {
//    assertThatNullPointerException().isThrownBy(() -> DaysOfWeekBitmaskConverter.apply(null))
//      .withMessage("Days-of-week bitmask must not be null.");
//  }
//}