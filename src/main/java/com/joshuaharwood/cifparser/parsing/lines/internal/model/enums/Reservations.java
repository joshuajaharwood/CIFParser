package com.joshuaharwood.cifparser.parsing.lines.internal.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.literals.Literal;

public enum Reservations implements Literal {
  RESERVATIONS_COMPULSORY("A", "Reservations compulsory"),
  RESERVATIONS_FOR_BICYCLES_ESSENTIAL("E", "Reservations for bicycles essential"),
  RESERVATIONS_RECOMMENDED("R", "Reservations recommended"),
  RESERVATIONS_POSSIBLE_FROM_ANY_STATION("S", "Reservations possible from any station");

  private final String literal;
  private final String description;

  Reservations(String literal, String description) {
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
