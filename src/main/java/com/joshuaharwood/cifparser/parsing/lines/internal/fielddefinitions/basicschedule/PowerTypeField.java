package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.POWER_TYPE_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import java.util.function.Function;

public record PowerTypeField() implements BasicScheduleField<PowerType> {
  @Override
  public int startIndex() {
    return 50;
  }

  @Override
  public String name() {
    return "POWER_TYPE";
  }

  @Override
  public int length() {
    return 3;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, PowerType> converter() {
    return POWER_TYPE_CONVERTER;
  }
}
