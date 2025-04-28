package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;

public non-sealed class DateRunsFromField implements BasicScheduleField<LocalDate> {

  private static final InverseDateConverter CONVERTER = InverseDateConverter.getInstance();

  DateRunsFromField() {
  }

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "DATE_RUNS_FROM";
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
    return "DateRunsFromField[]";
  }

}
