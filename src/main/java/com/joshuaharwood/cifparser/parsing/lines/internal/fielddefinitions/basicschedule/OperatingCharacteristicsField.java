package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.OPERATING_CHARACTERISTICS_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import java.util.Set;
import java.util.function.Function;

public record OperatingCharacteristicsField() implements
  BasicScheduleField<Set<OperatingCharacteristics>> {
  @Override
  public int startIndex() {
    return 60;
  }

  @Override
  public String name() {
    return "OPERATING_CHARACTERISTICS";
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
  public Function<String, Set<OperatingCharacteristics>> converter() {
    return OPERATING_CHARACTERISTICS_CONVERTER;
  }
}
