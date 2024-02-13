package com.joshuaharwood.cifparser.parsing.lines.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;

public enum StpIndicator implements Literal {
  STP_CANCELLATION_OF_PERMANENT_ASSOCIATION("C"),
  NEW_STP_ASSOCIATION("N"),
  STP_OVERLAY_OF_PERMANENT_ASSOCIATION("O"),
  PERMANENT_ASSOCIATION("P");

  private final String literal;

  StpIndicator(String literal) {
    this.literal = literal;
  }

  @Override
  public String getLiteral() {
    return literal;
  }
}
