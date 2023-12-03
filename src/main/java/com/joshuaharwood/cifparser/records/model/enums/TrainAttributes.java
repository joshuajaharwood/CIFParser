package com.joshuaharwood.cifparser.records.model.enums;

import com.joshuaharwood.cifparser.records.model.literals.CharLiteral;

public enum TrainAttributes implements CharLiteral {
  VACUUM_BRAKED('B', "Vacuum Braked"),
  TIMED_100_MPH('C', "Timed at 100 m.p.h."),
  DOO('D', "DOO (Coaching stock trains)"),
  CONVEYS_MARK_4_COACHES('E', "Conveys Mark 4 Coaches"),
  TRAINMAN_REQUIRED('G', "Trainman (Guard) required"),
  TIMED_110_MPH('M', "Timed at 110 m.p.h."),
  PUSH_PULL_TRAIN('P', "Push/Pull train"),
  RUNS_AS_REQUIRED('Q', "Runs as required"),
  AIR_CONDITIONED_PA_SYSTEM('R', "Air conditioned with PA system"),
  STEAM_HEATED('S', "Steam Heated"),
  RUNS_TO_TERMINAL_YARDS('Y', "Runs to Terminals/Yards as required"),
  MAY_CONVEY_TRAFFIC('Z',
      "May convey traffic to SB1C gauge. Not to be diverted from booked route without authority.");

  private final char literal;
  private final String description;

  TrainAttributes(char literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public char getLiteral() {
    return literal;
  }
}