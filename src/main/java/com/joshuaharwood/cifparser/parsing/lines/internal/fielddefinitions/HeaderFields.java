package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public enum HeaderFields implements RowField {
  RECORD_IDENTITY(1, 2),
  FILE_IDENTITY(2, 20),
  DATE_OF_EXTRACT(3, 6),
  TIME_OF_EXTRACT(4, 4),
  CURRENT_FILE_REFERENCE(5, 7),
  LAST_FILE_REFERENCE(6, 7),
  UPDATE_INDICATOR(7, 1),
  VERSION(8, 1),
  EXTRACT_START_DATE(9, 6),
  EXTRACT_END_DATE(10, 6),
  SPARE(11, 20);

  private final int order;
  private final int length;

  HeaderFields(int order, int length) {
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
