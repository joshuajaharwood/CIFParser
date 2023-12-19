package com.joshuaharwood.cifparser.records.model.literals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.records.model.enums.PowerType;
import org.junit.jupiter.api.Test;

class StringLiteralTest {

  @Test
  void parseLiteralWithNullEnumTypeThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> StringLiteral.parseLiteral(null, "e"));
  }

  @Test
  void parseLiteralWithNullStringReturnsEmptyOptional() {
    assertThat(StringLiteral.parseLiteral(PowerType.class, null)).isEmpty();
  }

  @Test
  void parseLiteralWithWhitespaceStringReturnsEmptyOptional() {
    assertThat(StringLiteral.parseLiteral(PowerType.class, "   ")).isEmpty();
  }

  @Test
  void parseLiteralWithWrongStringThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringLiteral.parseLiteral(PowerType.class,
            "XXX"))
        .withMessage(
            "Failed to map String for given StringLiteral. [String: XXX] [Enum: PowerType]");
  }

  @Test
  void parseLiteralWithRightStringButLowercaseReturnsCorrectEnumInstance() {
    assertThat(StringLiteral.parseLiteral(PowerType.class,
        "emu")).hasValue(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }

  @Test
  void parseLiteralWithRightStringReturnsCorrectEnumInstance() {
    assertThat(StringLiteral.parseLiteral(PowerType.class,
        "EMU")).hasValue(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }
}