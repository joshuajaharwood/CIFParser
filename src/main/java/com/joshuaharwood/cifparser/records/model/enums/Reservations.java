package com.joshuaharwood.cifparser.records.model.enums;

public enum Reservations {
  RESERVATIONS_COMPULSORY('A', "Reservations compulsory"),
  RESERVATIONS_FOR_BICYCLES_ESSENTIAL('E', "Reservations for bicycles essential"),
  RESERVATIONS_RECOMMENDED('R', "Reservations recommended"),
  RESERVATIONS_POSSIBLE_FROM_ANY_STATION('S', "Reservations possible from any station");

  private final char literal;
  private final String description;

  Reservations(char literal, String description) {
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
