package com.joshuaharwood.cifparser.parsing.lines.internal.model.fielddefinitions;

public enum TrailerFields implements RowField {
  RECORD_IDENTITY(1, 2),
  SPARE(2, 78);

  private final int order;
  private final int length;

  TrailerFields(int order, int length) {
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
