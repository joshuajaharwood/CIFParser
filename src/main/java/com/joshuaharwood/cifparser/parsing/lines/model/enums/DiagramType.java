package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum DiagramType implements Literal {
  T("T");

  private final String literal;


  DiagramType(String literal) {
    this.literal = literal;
  }

  @Override
  public String getLiteral() {
    return literal;
  }
}
