package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.SLEEPERS_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import java.util.function.Function;

public record SleepersField() implements BasicScheduleField<Sleepers> {

  @Override
  public int order() {
    return 20;
  }

  @Override
  public String name() {
    return "SLEEPERS";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, Sleepers> converter() {
    return SLEEPERS_CONVERTER;
  }
}
