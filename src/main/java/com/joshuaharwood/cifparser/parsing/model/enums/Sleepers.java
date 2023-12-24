package com.joshuaharwood.cifparser.parsing.model.enums;

public enum Sleepers {
  FIRST_AND_STANDARD_CLASS('B', "First and standard class"),
  FIRST_CLASS_ONLY('F', "First class only"),
  STANDARD_CLASS_ONLY('S', "Standard class only");

  private final char literal;
  private final String description;

  Sleepers(char literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public char getLiteral() {
    return literal;
  }

  public String getDescription() {
    return description;
  }
}
