package com.joshuaharwood.cifparser.parsing.lines.model.enums;

public enum TrainStatusSchedulingType {
  SHORT_TERM_PLANNING("STP"),
  WORKING_TIMETABLE("WTT");

  private final String acronym;

  TrainStatusSchedulingType(String acronym) {
    this.acronym = acronym;
  }

  @SuppressWarnings("unused")

  public String getAcronym() {
    return acronym;
  }
}
