package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

public record PublicArrivalTimeField() implements TerminatingLocationField<Optional<LocalTime>> {

  @Override
  public int startIndex() {
    return 15;
  }

  @Override
  public String name() {
    return "PUBLIC_ARRIVAL_TIME";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, Optional<LocalTime>> converter() {
    return ZeroSafeTimeConverter.getInstance()::apply;
  }
}