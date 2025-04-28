package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.BankHolidayRunning;

public non-sealed class BankHolidayRunningField implements BasicScheduleField<BankHolidayRunning> {

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
  public String toString() {
    return "BankHolidayRunningField[]";
  }

}
