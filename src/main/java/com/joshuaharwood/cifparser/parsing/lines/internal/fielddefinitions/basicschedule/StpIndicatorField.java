package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.STP_INDICATOR_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import java.util.function.Function;

public record StpIndicatorField() implements BasicScheduleField<StpIndicator> {

  @Override
  public int order() {
    return 26;
  }

  @Override
  public String name() {
    return "STP_INDICATOR";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, StpIndicator> converter() {
    return STP_INDICATOR_CONVERTER;
  }
}
