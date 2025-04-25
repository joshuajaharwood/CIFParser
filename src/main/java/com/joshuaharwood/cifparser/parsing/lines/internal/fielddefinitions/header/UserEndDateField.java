package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.LocalDate;
import java.util.Optional;

public record UserEndDateField() implements HeaderField<LocalDate> {

  @Override
  public int startIndex() {
    return 54;
  }

  @Override
  public String name() {
    return "USER_END_DATE";
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
    return DateConverter.getInstance().apply(raw).orElseThrow(IllegalArgumentException::new);
  }
}
