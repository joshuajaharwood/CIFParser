package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum ApplicableTimetableCode implements Literal {
  APPLICABLE("Y"),
  NOT_APPLICABLE("N");

  private final String literal;

  ApplicableTimetableCode(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
