package com.joshuaharwood.cifparser.parsing.model.enums;

public enum ApplicableTimetableCode {
  APPLICABLE('Y'),
  NOT_APPLICABLE('N');

  private final char literal;

  ApplicableTimetableCode(char literal) {
    this.literal = literal;
  }

  public char getLiteral() {
    return literal;
  }
}
