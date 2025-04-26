package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public record ScheduledDepartureTimeField() implements IntermediateLocationField<LocalTime> {
  private static final FiveDigitTimeConverter CONVERTER = FiveDigitTimeConverter.getInstance();

  @Override
  public int startIndex() {
    return 15;
  }

  @Override
  public String name() {
    return "SCHEDULED_DEPARTURE_TIME";
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
}