package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class TractionClassField implements ChangeEnRouteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  TractionClassField() {
  }

  @Override
  public int startIndex() {
    return 58;
  }

  @Override
  public String name() {
    return "TRACTION_CLASS";
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
  public String convert(String raw) {
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
    return "TractionClassField[]";
  }

}