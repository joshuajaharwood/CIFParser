package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;

public non-sealed class PowerTypeField implements BasicScheduleField<PowerType> {

  private static final LiteralConverter<PowerType> CONVERTER = LiteralConverter.create(PowerType.class);

  PowerTypeField() {
  }

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
  public PowerType convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "PowerTypeField[]";
  }

}
