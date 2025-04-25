package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

public record ScheduledArrivalTimeField() implements TerminatingLocationField<Optional<LocalTime>> {

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
  public Function<String, Optional<LocalTime>> converter() {
    return FiveDigitTimeConverter.getInstance()::apply;
  }
}