package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public enum TerminatingLocationFields implements RowField {
  RECORD_IDENTITY(1, 2),
  LOCATION(2, 8),
  SCHEDULED_ARRIVAL_TIME(3, 5),
  PUBLIC_ARRIVAL_TIME(4, 4),
  PLATFORM(5, 3),
  PATH(6, 3),
  ACTIVITY(7, 12),
  SPARE(8, 43);

  private final int order;
  private final int length;

  TerminatingLocationFields(int order, int length) {
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
