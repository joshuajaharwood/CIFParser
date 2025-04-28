package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import java.time.LocalTime;

public non-sealed class TimeOfExtractField implements HeaderField<LocalTime> {

  private static final TimeConverter CONVERTER = TimeConverter.getInstance();

  TimeOfExtractField() {
  }

  @Override
  public int startIndex() {
    return 28;
  }

  @Override
  public String name() {
    return "TIME_OF_EXTRACT";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return true;
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
    return "TimeOfExtractField[]";
  }

}
