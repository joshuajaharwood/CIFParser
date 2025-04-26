package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.LocalDate;
import java.util.Optional;

public record DateOfExtractField() implements HeaderField<LocalDate> {

  private static final DateConverter CONVERTER = DateConverter.getInstance();

  @Override
  public int startIndex() {
    return 22;
  }

  @Override
  public String name() {
    return "DATE_OF_EXTRACT";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public LocalDate convert(String raw) {
    return CONVERTER.apply(raw).orElseThrow(IllegalArgumentException::new);
  }
}
