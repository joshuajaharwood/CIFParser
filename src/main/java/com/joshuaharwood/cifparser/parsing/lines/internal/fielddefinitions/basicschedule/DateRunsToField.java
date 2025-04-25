package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;

public record DateRunsToField() implements BasicScheduleField<LocalDate> {

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
    return InverseDateConverter.getInstance().apply(raw);
  }
}
