package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;

public non-sealed class SleepersField implements BasicScheduleField<Sleepers> {

  private static final LiteralConverter<Sleepers> CONVERTER = LiteralConverter.create(Sleepers.class);

  SleepersField() {
  }

  @Override
  public int startIndex() {
    return 67;
  }

  @Override
  public String name() {
    return "SLEEPERS";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Sleepers convert(String raw) {
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
    return "SleepersField[]";
  }

}
