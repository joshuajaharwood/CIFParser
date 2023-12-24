package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;

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
