package com.joshuaharwood.cifparser.parsing.lines.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;

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
