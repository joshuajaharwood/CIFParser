package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class AssociationUidField implements AssociationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  AssociationUidField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "AssociationUidField[]";
  }

}
