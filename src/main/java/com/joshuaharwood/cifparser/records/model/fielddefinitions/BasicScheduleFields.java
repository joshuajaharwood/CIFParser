package com.joshuaharwood.cifparser.records.model.fielddefinitions;

public enum BasicScheduleFields implements RowField {
  RECORD_IDENTITY(1, 2),
  TRANSACTION_TYPE(2, 2),
  TRAIN_UID(3, 6),
  DATE_RUNS_FROM(4, 6),
  DATE_RUNS_TO(5, 6),
  DAYS_RUN(6, 7),
  BANK_HOLIDAY_RUNNING(7, 1),
  TRAIN_STATUS(8, 1),
  TRAIN_CATEGORY(9, 2),
  TRAIN_IDENTITY(10, 4),
  HEADCODE(11, 4),
  COURSE_INDICATOR(12, 1),
  PROFIT_CENTRE_CODE_TRAIN_CENTRE_CODE(13, 8),
  BUSINESS_SECTOR(14, 1),
  POWER_TYPE(15, 3),
  TIMING_LOAD(16, 4),
  SPEED(17, 3),
  OPERATING_CHARACTERISTICS(18, 6),
  TRAIN_CLASS(19, 1),
  SLEEPERS(19, 1),
  RESERVATIONS(20, 1),
  CONNECT_INDICATOR(21, 1),
  CATERING_CODE(22, 4),
  SERVICE_BRANDING(23, 4),
  SPARE(24, 1),
  STP_INDICATOR(25, 1);

  private final int order;
  private final int length;

  BasicScheduleFields(int order, int length) {
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
