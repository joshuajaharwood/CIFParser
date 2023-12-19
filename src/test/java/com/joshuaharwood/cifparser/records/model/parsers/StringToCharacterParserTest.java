package com.joshuaharwood.cifparser.records.model.parsers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class StringToCharacterParserTest {

  @Test
  public void parseWithMultipleCharactersThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringToCharacterParser.parse("ee"))
        .withMessage("Given string was longer than one character.");
  }

  @Test
  public void parseWithOnlyWhitespaceReturnsEmptyOptional() {
    assertThat(StringToCharacterParser.parse(" ")).isEmpty();
  }

  @Test
  public void parseWithOneCharacterStringReturnsCharacter() {
    assertThat(StringToCharacterParser.parse("e")).contains('e');
  }

  @Test
  public void parseWithOneCharacterPaddedThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringToCharacterParser.parse(" e"))
        .withMessage("Given string was longer than one character.");
  }
}