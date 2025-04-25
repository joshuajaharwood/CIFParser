package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record TpsDescriptionField() implements TiplocAmendField<String> {

  @Override
  public int startIndex() {
    return 18;
  }

  @Override
  public String name() {
    return "TPS_DESCRIPTION";
  }

  @Override
  public int length() {
    return 26;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}