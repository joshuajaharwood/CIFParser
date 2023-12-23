package com.joshuaharwood.cifparser.records.model.fielddefinitions;

public enum LocationIntermediateFields implements RowField {
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

  LocationIntermediateFields(int order, int length) {
    this.order = order;
    this.length = length;
  }

  @Override
  public int getOrder() {
    return order;
  }

  @Override
  public String getName() {
    return toString();
  }

  @Override
  public int getLength() {
    return length;
  }
}
