package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class ActivityField implements IntermediateLocationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  ActivityField() {
  }

  @Override
  public int startIndex() {
    return 42;
  }

  @Override
  public String name() {
    return "ACTIVITY";
  }

  @Override
  public int length() {
    return 12;
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
  public String toString() {
    return "ActivityField[]";
  }

}