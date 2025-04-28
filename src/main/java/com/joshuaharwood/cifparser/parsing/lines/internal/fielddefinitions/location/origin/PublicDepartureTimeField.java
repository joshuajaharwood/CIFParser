package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public non-sealed class PublicDepartureTimeField implements
  OriginLocationField<Optional<LocalTime>> {

  private static final ZeroSafeTimeConverter CONVERTER = ZeroSafeTimeConverter.getInstance();

  PublicDepartureTimeField() {
  }

  @Override
  public int startIndex() {
    return 15;
  }

  @Override
  public String name() {
    return "PUBLIC_DEPARTURE_TIME";
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
    return "PublicDepartureTimeField[]";
  }

}