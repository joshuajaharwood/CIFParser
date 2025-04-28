package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public non-sealed class PublicArrivalField implements
  IntermediateLocationField<Optional<LocalTime>> {

  private static final ZeroSafeTimeConverter CONVERTER = ZeroSafeTimeConverter.getInstance();

  PublicArrivalField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "PublicArrivalField[]";
  }

}