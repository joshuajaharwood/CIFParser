package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class FillerField implements AssociationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  FillerField() {
  }

  @Override
  public int startIndex() {
    return 48;
  }

  @Override
  public String name() {
    return "FILLER";
  }

  @Override
  public int length() {
    return 31;
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
    return "FillerField[]";
  }

}
