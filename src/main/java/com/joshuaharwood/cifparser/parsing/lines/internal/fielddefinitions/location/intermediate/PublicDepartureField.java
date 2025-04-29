package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;

public non-sealed class PublicDepartureField implements IntermediateLocationField<LocalTime> {

  private static final ZeroSafeTimeConverter CONVERTER = ZeroSafeTimeConverter.getInstance();

  PublicDepartureField() {
  }

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
  
  //FIXME: zerosafe converter nullability issue. investigate later.
  @SuppressWarnings("DataFlowIssue")
  @Override
  public LocalTime convert(String raw) {
    return CONVERTER.apply(raw).orElse(null);
  }

  @Override
  public String toString() {
    return "PublicDepartureField[]";
  }
}