package com.joshuaharwood.cifparser.parsing.model.literals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.parsing.model.enums.PowerType;
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
        .withMessage("Failed to map String for given StringLiteral. [String: XXX] [Enum: PowerType]");
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
}