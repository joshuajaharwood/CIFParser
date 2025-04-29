package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public non-sealed class PublicArrivalTimeField implements
  TerminatingLocationField<LocalTime> {

  private static final ZeroSafeTimeConverter CONVERTER = ZeroSafeTimeConverter.getInstance();

  PublicArrivalTimeField() {
  }

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

  // fixme: zero-safe converter nullability issue. investigate later.
  @SuppressWarnings("DataFlowIssue")
  @Override
  public LocalTime convert(String raw) {
    return CONVERTER.apply(raw).orElse(null);
  }


  @Override
  public String toString() {
    return "PublicArrivalTimeField[]";
  }

}