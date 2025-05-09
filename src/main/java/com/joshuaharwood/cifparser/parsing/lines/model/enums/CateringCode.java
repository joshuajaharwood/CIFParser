package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum CateringCode implements Literal {
  BUFFET_SERVICE("C", "Buffet Service"),
  RESTAURANT_CAR_AVAILABLE_FOR_FIRST_CLASS_PASSENGERS("F",
    "Restaurant Car available for First Class passengers"),
  HOT_FOOD_AVAILABLE("H", "Hot food available"),
  MEAL_INCLUDED_FOR_FIRST_CLASS_PASSENGERS("M", "Meal included for First Class passengers"),
  WHEELCHAIR_ONLY_RESERVATIONS("P", "Wheelchair only reservations"),
  RESTAURANT("R", "Restaurant"),
  TROLLEY_SERVICE("T", "Trolley service");

  private final String literal;
  private final String description;

  CateringCode(String literal, String description) {

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
