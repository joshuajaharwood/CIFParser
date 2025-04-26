package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum UpdateIndicator implements Literal {
  UPDATE_EXTRACT("U", "Update Extract"),
  FULL_EXTRACT("F", "Full Extract");
  private final String literal;
  private final String description;

  UpdateIndicator(String literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  @Override
  public String toString() {
    return "UpdateIndicator{" + "literal=" + literal + ", description='" + description + '\''
           + '}';
  }

  @Override
  public String getLiteral() {
    return this.literal;
  }
}
