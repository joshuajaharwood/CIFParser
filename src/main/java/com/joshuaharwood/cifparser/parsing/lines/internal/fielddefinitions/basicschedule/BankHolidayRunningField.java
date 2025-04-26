package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.BankHolidayRunning;

public final class BankHolidayRunningField implements BasicScheduleField<BankHolidayRunning> {

  private static final LiteralConverter<BankHolidayRunning> CONVERTER = LiteralConverter.create(
    BankHolidayRunning.class);

  BankHolidayRunningField() {
  }

  @Override
  public int startIndex() {
    return 28;
  }

  @Override
  public String name() {
    return "BANK_HOLIDAY_RUNNING";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public BankHolidayRunning convert(String raw) {
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "BankHolidayRunningField[]";
  }

}
