package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

public record PublicDepartureField() implements IntermediateLocationField<Optional<LocalTime>> {

  @Override
  public int startIndex() {
    return 29;
  }

  @Override
  public String name() {
    return "PUBLIC_DEPARTURE";
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