package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import java.time.LocalTime;
import java.util.Optional;

public record TimeOfExtractField() implements HeaderField<LocalTime> {

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
    return TimeConverter.getInstance().apply(raw).orElseThrow(IllegalArgumentException::new);
  }
}
