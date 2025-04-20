package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.util.function.Function;

public record UpdateIndicatorField() implements HeaderScheduleField<UpdateIndicator> {

  @Override
  public int startIndex() {
    return 46;
  }

  @Override
  public String name() {
    return "UPDATE_INDICATOR";
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
  public Function<String, UpdateIndicator> converter() {
    return LiteralConverter.create(UpdateIndicator.class);
  }
}
