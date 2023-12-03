package com.joshuaharwood.cifparser.records.model.enums;

public enum SeatingClass {
  FIRST_AND_STANDARD('B', "First and standard"),
  STANDARD('S', "Standard only");

  private final String description;
  private final char literal;

  SeatingClass(char literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public char getLiteral() {
    return literal;
  }
}
