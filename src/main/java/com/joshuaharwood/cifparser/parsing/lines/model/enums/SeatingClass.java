package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum SeatingClass implements Literal {
  FIRST_AND_STANDARD("B", "First and standard"),
  STANDARD("S", "Standard only");

  private final String description;
  private final String literal;

  SeatingClass(String literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public String getLiteral() {
    return literal;
  }
}
