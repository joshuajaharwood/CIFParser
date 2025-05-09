package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

public non-sealed class CapitalsIdentificationField implements TiplocAmendField<Byte> {

  CapitalsIdentificationField() {
  }

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "CAPITALS_IDENTIFICATION";
  }

  @Override
  public int length() {
    return 2;
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
    return "CapitalsIdentificationField[]";
  }

}