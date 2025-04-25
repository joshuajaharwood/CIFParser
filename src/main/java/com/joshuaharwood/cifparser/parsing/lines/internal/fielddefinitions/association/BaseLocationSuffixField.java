package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import java.util.function.Function;

public record BaseLocationSuffixField() implements AssociationField<Byte> {

  @Override
  public int startIndex() {
    return 44;
  }

  @Override
  public String name() {
    return "BASE_LOCATION_SUFFIX";
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
  public Function<String, Byte> converter() {
    return Byte::parseByte;
  }
}