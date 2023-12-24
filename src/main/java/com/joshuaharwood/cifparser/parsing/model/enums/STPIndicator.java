package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;

public enum STPIndicator implements Literal {
  STP_CANCELLATION_OF_PERMANENT_ASSOCIATION("C"),
  NEW_STP_ASSOCIATION("N"),
  STP_OVERLAY_OF_PERMANENT_ASSOCIATION(
      "O"),
  PERMANENT_ASSOCIATION("P");

  private final String literal;

  STPIndicator(String literal) {
    this.literal = literal;
  }

  @Override
  public String getLiteral() {
    return literal;
  }
}
