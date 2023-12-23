package com.joshuaharwood.cifparser.records.model.fielddefinitions;

public enum AssociationRowFields implements RowField {
  RECORD_IDENTITY(1, 2),
  TRANSACTION_TYPE(2, 1),
  BASE_UID(3, 6),
  ASSOCIATION_UID(4, 6),
  ASSOCIATION_START_DATE(5, 6),
  ASSOCIATION_END_DATE(6, 6),
  ASSOCIATION_DAYS(7, 7),
  ASSOCIATION_CATEGORY(8, 2),
  ASSOCIATION_DATE_INDICATOR(9, 1),
  ASSOCIATION_LOCATION(10, 7),
  BASE_LOCATION_SUFFIX(11, 1),
  ASSOCIATION_LOCATION_SUFFIX(12, 1),
  DIAGRAM_TYPE(13, 1),
  ASSOCIATION_TYPE(14, 1),
  FILLER(15, 31),
  STP_INDICATOR(16, 1);


  private final int order;
  private final int length;

  AssociationRowFields(int order, int length) {
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
