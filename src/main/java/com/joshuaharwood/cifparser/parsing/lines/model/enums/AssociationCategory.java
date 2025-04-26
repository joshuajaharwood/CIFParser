package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum AssociationCategory implements Literal {
  JOIN("JJ"),
  DIVIDE("VV"),
  NEXT("NP");

  private final String literal;

  AssociationCategory(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
