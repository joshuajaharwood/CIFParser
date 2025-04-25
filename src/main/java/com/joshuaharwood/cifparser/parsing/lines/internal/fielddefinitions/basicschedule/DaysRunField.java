package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import java.time.DayOfWeek;
import java.util.Set;

public record DaysRunField() implements BasicScheduleField<Set<DayOfWeek>> {

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
    return DaysOfWeekBitmaskConverter.getInstance().apply(raw);
  }
}
