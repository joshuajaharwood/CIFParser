package com.joshuaharwood.cifparser.records.model.literals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.records.model.AssociationRecord.AssociationDateIndicator;
import org.junit.jupiter.api.Test;

class CharLiteralTest {

  @Test
  void parseLiteralWithNullEnumTypeThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> CharLiteral.parseLiteral(null, 'e'));
  }

  @Test
  void parseLiteralWithNullCharReturnsEmptyOptional() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, null)).isEmpty();
  }

  @Test
  void parseLiteralWithWhitespaceCharReturnsEmptyOptional() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, ' ')).isEmpty();
  }

  @Test
  void parseLiteralWithWrongCharThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> CharLiteral.parseLiteral(
            AssociationDateIndicator.class,
            'e'))
        .withMessage(
            "Failed to map character for given CharLiteral. [Character: e] [Enum: AssociationDateIndicator]");
  }

  @Test
  void parseLiteralWithRightCharButLowercaseReturnsCorrectEnumInstance() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, 's')).hasValue(
        AssociationDateIndicator.STANDARD);
  }

  @Test
  void parseLiteralWithRightCharReturnsCorrectEnumInstance() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, 'S')).hasValue(
        AssociationDateIndicator.STANDARD);
  }
}