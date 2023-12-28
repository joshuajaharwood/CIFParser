package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;

public enum Sleepers implements Literal {
  FIRST_AND_STANDARD_CLASS("B", "First and standard class"),
  FIRST_CLASS_ONLY("F", "First class only"),
  STANDARD_CLASS_ONLY("S", "Standard class only");

  private final String literal;
  private final String description;

  Sleepers(String literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public String getLiteral() {
    return literal;
  }

  public String getDescription() {
    return description;
  }
}
