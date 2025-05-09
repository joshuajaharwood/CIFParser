//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class RecordSpecificParserTest {
//
//  private HeaderParser p;
//
//  @BeforeEach
//  public void setUp() {
//    p = new HeaderParser();
//  }
//
//  @Test
//  public void parseWithMultipleCharactersThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException().isThrownBy(() -> p.parseChar("ee"))
//                                        .withMessage("Given string was longer than one character.");
//  }
//
//  @Test
//  public void parseWithOnlyWhitespaceReturnsNull() {
//    assertThat(p.parseChar(" ")).isNull();
//  }
//
//  @Test
//  public void parseWithOneCharacterStringReturnsCharacter() {
//    assertThat(p.parseChar("e")).isEqualTo('e');
//  }
//
//  @Test
//  public void parseWithOneCharacterPaddedThrowsIllegalArgumentException() {
//    assertThatIllegalArgumentException().isThrownBy(() -> p.parseChar(" e"))
//                                        .withMessage("Given string was longer than one character.");
//  }
//}