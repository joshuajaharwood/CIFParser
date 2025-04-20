package com.joshuaharwood.cifparser.parsing.lines.model.enums;

import static com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatusSchedulingType.SHORT_TERM_PLANNING;
import static com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatusSchedulingType.WORKING_TIMETABLE;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import org.jspecify.annotations.Nullable;

public enum TrainStatus implements Literal {
  BUS_PERMANENT("B", null),
  FREIGHT_PERMANENT("F", WORKING_TIMETABLE),
  PASSENGER_AND_PARCELS_PERMANENT("P", WORKING_TIMETABLE),
  SHIP_PERMANENT("S", null),
  TRIP_PERMANENT("T", null),
  PASSENGER_AND_PARCELS("1", SHORT_TERM_PLANNING),
  FREIGHT("2", SHORT_TERM_PLANNING),
  TRIP("3", SHORT_TERM_PLANNING),
  SHIP("4", SHORT_TERM_PLANNING),
  BUS("5", SHORT_TERM_PLANNING);

  @Nullable
  private final TrainStatusSchedulingType schedulingType;
  private final String literal;

  TrainStatus(String literal, @Nullable TrainStatusSchedulingType schedulingType) {
    this.literal = literal;
    this.schedulingType = schedulingType;
  }

  @Override
  public String getLiteral() {
    return literal;
  }

  @SuppressWarnings("unused")
  public @Nullable TrainStatusSchedulingType getSchedulingType() {
    return schedulingType;
  }

}
