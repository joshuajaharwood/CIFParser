package com.joshuaharwood.cifparser.parsing.lines.internal.model.fielddefinitions;

public enum ChangeEnRouteFields implements RowField {
  RECORD_IDENTITY(1, 2),
  LOCATION(2, 8),
  TRAIN_CATEGORY(3, 2),
  TRAIN_IDENTITY(4, 4),
  HEADCODE(5, 4),
  COURSE_INDICATOR(6, 1),
  PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE(7, 8),
  BUSINESS_SECTOR(8, 1),
  POWER_TYPE(9, 3),
  TIMING_LOAD(10, 4),
  SPEED(11, 3),
  OPERATING_CHARACTERISTICS(12, 6),
  TRAIN_CLASS(13, 1),
  SLEEPERS(14, 1),
  RESERVATIONS(15, 1),
  CONNECT_INDICATOR(16, 1),
  CATERING_CODE(17, 4),
  SERVICE_BRANDING(18, 4),
  TRACTION_CLASS(19, 4),
  UIC_CODE(20, 5),
  RETAIL_SERVICE_ID(21, 8),
  SPARE(22, 5);

  private final int order;
  private final int length;

  ChangeEnRouteFields(int order, int length) {
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
