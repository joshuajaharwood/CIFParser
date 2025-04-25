package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralSetConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import java.util.Set;

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
    return false;
  }

  @Override
  public Set<CateringCode> convert(String raw) {
    return LiteralSetConverter.getInstance(CateringCode.class).apply(raw);
  }
}
