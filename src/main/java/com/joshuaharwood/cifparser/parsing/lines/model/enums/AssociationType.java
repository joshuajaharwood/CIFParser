package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum AssociationType implements Literal {
  PASSENGER_USE("P"),
  OPERATING_USE_ONLY("O");
  private final String literal;

  AssociationType(String literal) {
    this.literal = literal;
  }

  @Override
  public String getLiteral() {
    return literal;
  }
}
