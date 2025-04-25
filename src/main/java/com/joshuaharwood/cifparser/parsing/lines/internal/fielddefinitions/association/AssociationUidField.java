package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record AssociationUidField() implements AssociationField<String> {

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "ASSOCIATION_UID";
  }

  @Override
  public int length() {
    return 6;
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