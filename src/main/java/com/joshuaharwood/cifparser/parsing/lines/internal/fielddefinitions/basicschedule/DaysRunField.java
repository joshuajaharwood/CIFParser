package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.DAYS_OF_WEEK_BITMASK_CONVERTER;

import java.time.DayOfWeek;
import java.util.Set;
import java.util.function.Function;

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
  public Function<String, Set<DayOfWeek>> converter() {
    return DAYS_OF_WEEK_BITMASK_CONVERTER;
  }
}
