package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.LocalDate;

public non-sealed class DateOfExtractField implements HeaderField<LocalDate> {

  private static final DateConverter CONVERTER = DateConverter.getInstance();

  DateOfExtractField() {
  }

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
    return "DateOfExtractField[]";
  }

}
