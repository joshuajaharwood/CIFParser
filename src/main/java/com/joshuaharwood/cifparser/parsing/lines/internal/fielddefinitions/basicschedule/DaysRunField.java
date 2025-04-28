package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import java.time.DayOfWeek;
import java.util.Set;

public non-sealed class DaysRunField implements BasicScheduleField<Set<DayOfWeek>> {

  private static final DaysOfWeekBitmaskConverter CONVERTER = DaysOfWeekBitmaskConverter.getInstance();

  DaysRunField() {
  }

  @Override
  public int startIndex() {
    return 21;
  }

  @Override
  public String name() {
    return "DAYS_RUN";
  }

  @Override
  public int length() {
    return 7;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Set<DayOfWeek> convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "DaysRunField[]";
  }

}
