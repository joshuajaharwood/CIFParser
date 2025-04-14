package com.joshuaharwood.cifparser.parsing.model.literals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
import org.junit.jupiter.api.Test;

class LiteralLookupTest {

  @Test
  void parseLiteralWithNullStringReturnsEmptyOptional() {
    assertThat(LiteralLookup.lookup(PowerType.class, null)).isEmpty();
  }

  @Test
  void parseLiteralWithWhitespaceStringReturnsEmptyOptional() {
    assertThat(LiteralLookup.lookup(PowerType.class, "   ")).isEmpty();
  }

  @Test
  void parseLiteralWithWrongStringThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> LiteralLookup.lookup(PowerType.class,
        "XXX"))
      .withMessage("Failed to map String for given Literal. [String: XXX] [Enum: PowerType]");
  }

  @Test
  void parseLiteralWithRightStringButLowercaseReturnsCorrectEnumInstance() {
    assertThat(LiteralLookup.lookup(PowerType.class,
      "emu")).hasValue(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }

  @Test
  void parseLiteralWithRightStringReturnsCorrectEnumInstance() {
    assertThat(LiteralLookup.lookup(PowerType.class,
      "EMU")).hasValue(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }

  @Test
  void lookupSetReturnsAllCorrectEnums() {
    assertThat(LiteralLookup.lookupSet(OperatingCharacteristics.class,
      "BCDEGM")).containsExactly(OperatingCharacteristics.VACUUM_BRAKED,
      OperatingCharacteristics.TIMED_100_MPH,
      OperatingCharacteristics.DOO,
      OperatingCharacteristics.CONVEYS_MARK_4_COACHES,
      OperatingCharacteristics.TRAINMAN_REQUIRED,
      OperatingCharacteristics.TIMED_110_MPH).isUnmodifiable();
  }

  @Test
  void lookupSetReturnsAllCorrectEnumsWithPaddedInput() {
    assertThat(LiteralLookup.lookupSet(OperatingCharacteristics.class,
      " BCD  ")).containsExactly(OperatingCharacteristics.VACUUM_BRAKED,
      OperatingCharacteristics.TIMED_100_MPH,
      OperatingCharacteristics.DOO).isUnmodifiable();
  }

  @Test
  void lookupSetThrowsIllegalArgumentExceptionWithBadData() {
    // A is not a valid OperatingCharacteristic literal
    assertThatIllegalArgumentException().isThrownBy(() -> LiteralLookup.lookupSet(
        OperatingCharacteristics.class,
        "ACDEGM"))
      .withMessage(
        "Failed to map String for given Literal. [String: A] [Enum: OperatingCharacteristics]");
  }

  @Test
  void lookupSetThrowsIllegalArgumentExceptionWithBlankData() {
    assertThat(LiteralLookup.lookupSet(OperatingCharacteristics.class,
      "   ")).isUnmodifiable().isEmpty();
  }

  @Test
  void lookupSetThrowsIllegalArgumentExceptionWithNullData() {
    assertThat(LiteralLookup.lookupSet(OperatingCharacteristics.class,
      null)).isUnmodifiable().isEmpty();
  }
}