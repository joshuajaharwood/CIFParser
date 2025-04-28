package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;

public non-sealed class StpIndicatorField implements BasicScheduleField<StpIndicator> {

  private static final LiteralConverter<StpIndicator> CONVERTER = LiteralConverter.create(
    StpIndicator.class);

  StpIndicatorField() {
  }

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
  public StpIndicator convert(String raw) {
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "StpIndicatorField[]";
  }

}
