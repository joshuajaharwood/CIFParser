package com.joshuaharwood.cifparser.records.model.fielddefinitions;

public enum BasicScheduleExtendedFields implements RowField {
  RECORD_IDENTITY(1, 2),
  TRACTION_CLASS(2, 4),
  UIC_CODE(3, 5),
  ATOC_CODE(4, 2),
  APPLICABLE_TIMETABLE_CODE(5, 1),
  RETAIL_SERVICE_ID(6, 8),
  SOURCE(7, 1),
  SPARE(8, 57);

  private final int order;
  private final int length;

  BasicScheduleExtendedFields(int order, int length) {
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
