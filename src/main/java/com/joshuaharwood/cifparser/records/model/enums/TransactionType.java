package com.joshuaharwood.cifparser.records.model.enums;

import com.joshuaharwood.cifparser.records.model.literals.CharLiteral;

public enum TransactionType implements CharLiteral {
  NEW('N'),
  DELETE('D'),
  REVISE('R');

  private final char literal;

  TransactionType(char literal) {
    this.literal = literal;
  }

  public char getLiteral() {
    return literal;
  }
}
