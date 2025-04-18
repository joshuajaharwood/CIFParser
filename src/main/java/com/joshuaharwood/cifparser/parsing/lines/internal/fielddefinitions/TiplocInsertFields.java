package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public enum TiplocInsertFields implements RowField {
  RECORD_IDENTITY(1, 2),
  TIPLOC_CODE(2, 7),
  CAPITALS(3, 2),
  NATIONAL_LOCATION_CODE(4, 6),
  NLC_CHECK_CHARACTER(5, 1),
  TPS_DESCRIPTION(6, 26),
  STANOX(7, 5),
  PO_MCP_CODE(8, 4),
  CRS_CODE(9, 3),
  DESCRIPTION(10, 16),
  SPARE(11, 8);

  private final int order;
  private final int length;

  TiplocInsertFields(int order, int length) {
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
