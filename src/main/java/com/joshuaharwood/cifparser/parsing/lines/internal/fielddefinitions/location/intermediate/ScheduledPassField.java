package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

public record ScheduledPassField() implements IntermediateLocationField<Optional<LocalTime>> {

  @Override
  public int startIndex() {
    return 20;
  }

  @Override
  public String name() {
    return "SCHEDULED_PASS";
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