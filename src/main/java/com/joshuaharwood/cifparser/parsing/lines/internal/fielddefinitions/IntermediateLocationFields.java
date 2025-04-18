package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public enum IntermediateLocationFields implements RowField {
  RECORD_IDENTITY(1, 2),
  LOCATION(2, 8),
  SCHEDULED_ARRIVAL_TIME(3, 5),
  SCHEDULED_DEPARTURE_TIME(4, 5),
  SCHEDULED_PASS(5, 5),
  PUBLIC_ARRIVAL(6, 4),
  PUBLIC_DEPARTURE(7, 4),
  PLATFORM(8, 3),
  LINE(9, 3),
  PATH(10, 3),
  ACTIVITY(11, 12),
  ENGINEERING_ALLOWANCE(12, 2),
  PATHING_ALLOWANCE(13, 2),
  PERFORMANCE_ALLOWANCE(14, 2),
  SPARE(15, 20);

  private final int order;
  private final int length;

  IntermediateLocationFields(int order, int length) {
    this.order = order;
    this.length = length;
  }

  @Override
  public int order() {
    return order;
  }

  @Override
  public String name() {
    return toString();
  }

  @Override
  public int length() {
    return length;
  }
}
