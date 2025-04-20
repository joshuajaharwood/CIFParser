package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import java.util.function.Function;

public record StpIndicatorField() implements BasicScheduleField<StpIndicator> {
  @Override
  public int startIndex() {
    return 79;
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
    return LiteralConverter.create(StpIndicator.class);
  }
}
