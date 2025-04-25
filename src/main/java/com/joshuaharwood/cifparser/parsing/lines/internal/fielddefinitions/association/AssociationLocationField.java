package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record AssociationLocationField() implements AssociationField<String> {

  @Override
  public int startIndex() {
    return 37;
  }

  @Override
  public String name() {
    return "ASSOCIATION_LOCATION";
  }

  @Override
  public int length() {
    return 7;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}