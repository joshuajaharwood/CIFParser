package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

public final class ConnectIndicatorField implements BasicScheduleField<Character> {

  private static final DefaultCharConverter CONVERTER = DefaultCharConverter.getInstance();

  ConnectIndicatorField() {
  }

  @Override
  public int startIndex() {
    return 69;
  }

  @Override
  public String name() {
    return "CONNECT_INDICATOR";
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
  public Character convert(String raw) {
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
    return "ConnectIndicatorField[]";
  }

}
