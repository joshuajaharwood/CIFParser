package com.joshuaharwood.cifparser.parsing.model.fielddefinitions;

public enum TiplocDeleteFields implements RowField {
  RECORD_IDENTITY(1, 2),
  TIPLOC_CODE(2, 7),
  SPARE(3, 71);

  private final int order;
  private final int length;

  TiplocDeleteFields(int order, int length) {
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
