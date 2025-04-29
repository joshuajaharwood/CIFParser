package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

public non-sealed class BaseLocationSuffixField implements AssociationField<Byte> {

  BaseLocationSuffixField() {
  }

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
    return false;
  }

  @Override
  public Byte convert(String raw) {
    return Byte.parseByte(raw);
  }


  @Override
  public String toString() {
    return "BaseLocationSuffixField[]";
  }

}