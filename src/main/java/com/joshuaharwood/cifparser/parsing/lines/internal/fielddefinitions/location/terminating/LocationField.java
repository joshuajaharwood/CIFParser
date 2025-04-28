package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class LocationField implements TerminatingLocationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  LocationField() {
  }

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "LOCATION";
  }

  @Override
  public int length() {
    return 8;
  }

  @Override
  public boolean isRequired() {
    return true;
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
    return "LocationField[]";
  }

}