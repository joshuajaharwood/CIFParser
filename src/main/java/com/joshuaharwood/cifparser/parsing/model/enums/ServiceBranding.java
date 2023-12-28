package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;

public enum ServiceBranding implements Literal {
  EUROSTAR("E", "Eurostar");

  private final String literal;

  private final String description;

  ServiceBranding(String literal, String description) {
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
