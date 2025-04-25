package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public record PublicArrivalField() implements IntermediateLocationField<Optional<LocalTime>> {

  @Override
  public int startIndex() {
    return 25;
  }

  @Override
  public String name() {
    return "PUBLIC_ARRIVAL";
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
  public Optional<LocalTime> convert(String raw) {
    return ZeroSafeTimeConverter.getInstance().apply(raw);
  }
}