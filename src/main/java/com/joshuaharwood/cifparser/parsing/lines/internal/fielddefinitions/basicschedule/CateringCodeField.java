package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.CATERING_CODE_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import java.util.Set;
import java.util.function.Function;

public record CateringCodeField() implements BasicScheduleField<Set<CateringCode>> {

  @Override
  public int startIndex() {
    return 70;
  }

  @Override
  public String name() {
    return "CATERING_CODE";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, Set<CateringCode>> converter() {
    return CATERING_CODE_CONVERTER;
  }
}
