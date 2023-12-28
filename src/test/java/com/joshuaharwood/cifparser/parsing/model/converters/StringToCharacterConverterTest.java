package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class StringToCharacterConverterTest {

  @Test
  public void parseWithMultipleCharactersThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringToCharacterConverter.convert("ee"))
        .withMessage("Given string was longer than one character.");
  }

  @Test
  public void parseWithOnlyWhitespaceReturnsEmptyOptional() {
    assertThat(StringToCharacterConverter.convert(" ")).isEmpty();
  }

  @Test
  public void parseWithOneCharacterStringReturnsCharacter() {
    assertThat(StringToCharacterConverter.convert("e")).contains('e');
  }

  @Test
  public void parseWithOneCharacterPaddedThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringToCharacterConverter.convert(" e"))
        .withMessage("Given string was longer than one character.");
  }
}