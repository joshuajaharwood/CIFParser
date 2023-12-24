package com.joshuaharwood.cifparser.parsing.model.enums;

public enum ServiceBranding {
  EUROSTAR('E', "Eurostar");

  private final char literal;

  private final String description;

  ServiceBranding(char literal, String description) {
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
