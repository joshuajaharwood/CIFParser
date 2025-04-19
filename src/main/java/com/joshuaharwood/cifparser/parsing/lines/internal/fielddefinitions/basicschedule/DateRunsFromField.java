package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.INVERSE_DATE_CONVERTER;

import java.time.LocalDate;
import java.util.function.Function;

public record DateRunsFromField() implements BasicScheduleField<LocalDate> {

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
  public Function<String, LocalDate> converter() {
    return INVERSE_DATE_CONVERTER;
  }
}
