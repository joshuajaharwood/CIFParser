package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.UnknownLiteralException;
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
    //noinspection DataFlowIssue
    assertThatNullPointerException().isThrownBy(() -> literalConverter.apply(null));
  }

  @Test
  void parseLiteralWithWhitespaceStringReturnsEmptyOptional() {
    assertThatIllegalArgumentException().isThrownBy(() -> literalConverter.apply(" "))
      .withMessage("Literal string must not be blank.");
  }

  @Test
  void parseLiteralWithWrongStringThrowsIllegalArgumentException() {
    assertThatExceptionOfType(UnknownLiteralException.class).isThrownBy(() -> literalConverter.apply("XXX"))
      .withMessage("Failed to find matching literal for given String. [Literal class: PowerType] [Literal string: XXX]");
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