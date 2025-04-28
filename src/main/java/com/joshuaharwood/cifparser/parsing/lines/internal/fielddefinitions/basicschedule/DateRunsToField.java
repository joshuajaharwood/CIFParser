package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;

public non-sealed class DateRunsToField implements BasicScheduleField<LocalDate> {

  private static final InverseDateConverter CONVERTER = InverseDateConverter.getInstance();

  DateRunsToField() {
  }

  @Override
  public int startIndex() {
    return 15;
  }

  @Override
  public String name() {
    return "DATE_RUNS_TO";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public LocalDate convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "DateRunsToField[]";
  }

}
