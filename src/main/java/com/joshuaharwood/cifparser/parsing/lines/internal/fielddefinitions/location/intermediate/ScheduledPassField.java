package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import java.time.LocalTime;

public final class ScheduledPassField implements IntermediateLocationField<LocalTime> {

  private static final FiveDigitTimeConverter CONVERTER = FiveDigitTimeConverter.getInstance();

  ScheduledPassField() {
  }

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
  public LocalTime convert(String raw) {
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "ScheduledPassField[]";
  }

}