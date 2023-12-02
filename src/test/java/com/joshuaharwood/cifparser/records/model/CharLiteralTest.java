package com.joshuaharwood.cifparser.records.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.records.model.AssociationRecord.AssociationDateIndicator;
import org.junit.jupiter.api.Test;

class CharLiteralTest {

  @Test
  void parseLiteralWithNullEnumTypeThrowsIllegalArgumentException() {
    //noinspection DataFlowIssue
    assertThatIllegalArgumentException().isThrownBy(() -> CharLiteral.parseLiteral(null, 'e'));
  }

  @Test
  void parseLiteralWithNullCharReturnsEmptyOptional() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, null)).isEmpty();
  }

  @Test
  void parseLiteralWithWrongCharReturnsEmptyOptional() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, 'e')).isEmpty();
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

  @Test
  void parseLiteralWithNumberReturnsEmptyOptional() {
    assertThat(CharLiteral.parseLiteral(AssociationDateIndicator.class, '2')).isEmpty();
  }
}