package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

public non-sealed class AssociationLocationSuffixField implements AssociationField<Byte> {

  AssociationLocationSuffixField() {
  }

  @Override
  public int startIndex() {
    return 45;
  }

  @Override
  public String name() {
    return "ASSOCIATION_LOCATION_SUFFIX";
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
  public Byte convert(String raw) {
    return Byte.parseByte(raw);
  }


  @Override
  public String toString() {
    return "AssociationLocationSuffixField[]";
  }

}