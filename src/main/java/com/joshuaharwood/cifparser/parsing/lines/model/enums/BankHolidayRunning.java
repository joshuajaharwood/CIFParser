package com.joshuaharwood.cifparser.parsing.lines.model.enums;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;

public enum BankHolidayRunning implements Literal {
  NOT_ON_SPECIFIED_BANK_HOLIDAY_MONDAYS("X"),
  NOT_ON_GLASGOW_BANK_HOLIDAY("G");

  private final String literal;

  BankHolidayRunning(String literal) {
    this.literal = literal;
  }

  @Override
  public String getLiteral() {
    return literal;
  }
}
