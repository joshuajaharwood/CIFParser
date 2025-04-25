package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public record ScheduledArrivalTimeField() implements IntermediateLocationField<Optional<LocalTime>> {

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
  public Optional<LocalTime> convert(String raw) {
    return FiveDigitTimeConverter.getInstance().apply(raw);
  }
}