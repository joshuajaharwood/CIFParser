package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

public record CapitalsIdentificationField() implements TiplocAmendField<Byte> {

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
}