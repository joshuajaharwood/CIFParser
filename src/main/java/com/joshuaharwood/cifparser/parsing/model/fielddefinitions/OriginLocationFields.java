package com.joshuaharwood.cifparser.parsing.model.fielddefinitions;

public enum OriginLocationFields implements RowField {
  RECORD_IDENTITY(1, 2),
  LOCATION(2, 8),
  SCHEDULED_DEPARTURE_TIME(3, 5),
  PUBLIC_DEPARTURE_TIME(4, 4),
  PLATFORM(5, 3),
  LINE(6, 3),
  ENGINEERING_ALLOWANCE(7, 2),
  PATHING_ALLOWANCE(8, 2),
  ACTIVITY(9, 12),
  PERFORMANCE_ALLOWANCE(10, 2),
  SPARE(11, 37);

  private final int order;
  private final int length;

  OriginLocationFields(int order, int length) {
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
