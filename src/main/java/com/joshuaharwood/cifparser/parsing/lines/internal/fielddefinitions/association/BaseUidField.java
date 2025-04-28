package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class BaseUidField implements AssociationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  BaseUidField() {
  }

  @Override
  public int startIndex() {
    return 3;
  }

  @Override
  public String name() {
    return "BASE_UID";
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
    return "BaseUidField[]";
  }

}
