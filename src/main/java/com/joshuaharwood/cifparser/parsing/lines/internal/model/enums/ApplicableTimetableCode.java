package com.joshuaharwood.cifparser.parsing.lines.internal.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.literals.Literal;

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
