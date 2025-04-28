package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralSetConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import java.util.Set;

public non-sealed class OperatingCharacteristicsField implements
  BasicScheduleField<Set<OperatingCharacteristics>> {

  private static final LiteralSetConverter<OperatingCharacteristics> CONVERTER = LiteralSetConverter.getInstance(
    OperatingCharacteristics.class);

  OperatingCharacteristicsField() {
  }

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
    return false;
  }

  @Override
  public Set<OperatingCharacteristics> convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "OperatingCharacteristicsField[]";
  }

}
