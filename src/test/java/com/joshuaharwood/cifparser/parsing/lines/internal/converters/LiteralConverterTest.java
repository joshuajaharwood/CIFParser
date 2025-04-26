package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LiteralConverterTest {

  private LiteralConverter<@NonNull PowerType> literalConverter;

  @BeforeEach
  void setUp() {
    literalConverter = LiteralConverter.create(PowerType.class);
  }

  @Test
  void parseLiteralWithNullStringReturnsEmptyOptional() {
    assertThat(literalConverter.apply(null)).isNull();
  }

  @Test
  void parseLiteralWithWhitespaceStringReturnsEmptyOptional() {
    assertThat(literalConverter.apply("   ")).isNull();
  }

  @Test
  void parseLiteralWithWrongStringThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> literalConverter.apply("XXX"))
      .withMessage("Failed to map String for given Literal. [String: XXX] [Enum: PowerType]");
  }

  @Test
  void parseLiteralWithRightStringButLowercaseReturnsCorrectEnumInstance() {
    assertThat(literalConverter.apply("emu")).isEqualTo(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }

  @Test
  void parseLiteralWithRightStringReturnsCorrectEnumInstance() {
    assertThat(literalConverter.apply("EMU")).isEqualTo(PowerType.ELECTRIC_MULTIPLE_UNIT);
  }
}