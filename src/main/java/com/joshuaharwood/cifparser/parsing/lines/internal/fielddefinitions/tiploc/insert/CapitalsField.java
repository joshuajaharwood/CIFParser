package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

public non-sealed class CapitalsField implements TiplocInsertField<Byte> {

  CapitalsField() {
  }

  @Override
  public int startIndex() {
    return 9;
  }

  @Override
  public String name() {
    return "CAPITALS";
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
    return "CapitalsField[]";
  }

}