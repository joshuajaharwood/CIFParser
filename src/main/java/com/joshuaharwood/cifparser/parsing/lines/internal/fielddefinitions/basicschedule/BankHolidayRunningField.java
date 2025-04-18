package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.BANK_HOLIDAY_RUNNING_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.BankHolidayRunning;
import java.util.function.Function;

public record BankHolidayRunningField() implements BasicScheduleField<BankHolidayRunning> {

  @Override
  public int order() {
    return 7;
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
  public Function<String, BankHolidayRunning> converter() {
    return BANK_HOLIDAY_RUNNING_CONVERTER;
  }
}
