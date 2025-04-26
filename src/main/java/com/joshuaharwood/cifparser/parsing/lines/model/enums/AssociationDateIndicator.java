package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum AssociationDateIndicator implements Literal {
  STANDARD("S"),
  OVER_NEXT_MIDNIGHT("N"),
  OVER_PREVIOUS_MIDNIGHT("P");

  private final String literal;

  AssociationDateIndicator(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
