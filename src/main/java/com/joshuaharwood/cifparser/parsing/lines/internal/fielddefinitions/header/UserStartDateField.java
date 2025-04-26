package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.LocalDate;

public record UserStartDateField() implements HeaderField<LocalDate> {

  private static final DateConverter CONVERTER = DateConverter.getInstance();

  @Override
  public int startIndex() {
    return 48;
  }

  @Override
  public String name() {
    return "USER_START_DATE";
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
    return CONVERTER.apply(raw);
  }
}
