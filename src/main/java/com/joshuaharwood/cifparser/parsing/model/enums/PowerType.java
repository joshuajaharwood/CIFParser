package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;

public enum PowerType implements Literal {
  DIESEL("D", "Diesel"),
  DIESEL_ELECTRIC_MULTIPLE_UNIT("DEM", "Diesel Electric Multiple Unit"),
  DIESEL_MECHANICAL_MULTIPLE_UNIT("DMU", "Diesel Mechanical Multiple Unit"),
  ELECTRIC("E", "Electric"),
  ELECTRODIESEL("ED", "Electro-Diesel"),
  EMU_PLUS_D_E_ED_LOCOMOTIVE("EML", "EMU plus D, E, ED locomotive"),
  ELECTRIC_MULTIPLE_UNIT("EMU", "Electric Multiple Unit"),
  HIGH_SPEED_TRAIN("HST", "High Speed Train");

  private final String literal;
  private final String description;

  PowerType(String literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  @Override
  public String getLiteral() {
    return literal;
  }

  public String getDescription() {
    return description;
  }
}
