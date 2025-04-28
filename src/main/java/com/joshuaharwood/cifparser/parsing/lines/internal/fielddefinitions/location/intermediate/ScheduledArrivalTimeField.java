package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;

public non-sealed class ScheduledArrivalTimeField implements IntermediateLocationField<LocalTime> {

  private static final FiveDigitTimeConverter CONVERTER = FiveDigitTimeConverter.getInstance();

  ScheduledArrivalTimeField() {
  }

  @Override
  public int startIndex() {
    return 10;
  }

  @Override
  public String name() {
    return "SCHEDULED_ARRIVAL_TIME";
  }

  @Override
  public int length() {
    return 5;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public LocalTime convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "ScheduledArrivalTimeField[]";
  }

}