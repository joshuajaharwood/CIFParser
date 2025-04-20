package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;
import java.util.function.Function;

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
  public Function<String, LocalDate> converter() {
    return InverseDateConverter.getInstance();
  }
}
