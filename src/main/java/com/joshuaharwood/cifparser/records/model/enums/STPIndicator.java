package com.joshuaharwood.cifparser.records.model.enums;

import com.joshuaharwood.cifparser.records.model.literals.CharLiteral;

public enum STPIndicator implements CharLiteral {
  STP_CANCELLATION_OF_PERMANENT_ASSOCIATION('C'),
  NEW_STP_ASSOCIATION('N'),
  STP_OVERLAY_OF_PERMANENT_ASSOCIATION(
      'O'),
  PERMANENT_ASSOCIATION('P');

  private final char literal;

  STPIndicator(char literal) {
    this.literal = literal;
  }

  @Override
  public char getLiteral() {
    return literal;
  }
}
