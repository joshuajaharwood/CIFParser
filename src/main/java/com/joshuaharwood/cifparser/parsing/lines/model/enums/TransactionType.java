package com.joshuaharwood.cifparser.parsing.lines.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;

public enum TransactionType implements Literal {
  NEW("N"),
  DELETE("D"),
  REVISE("R");

  private final String literal;

  TransactionType(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
