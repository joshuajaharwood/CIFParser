package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class TpsDescriptionField implements TiplocAmendField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  TpsDescriptionField() {
  }

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
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "TpsDescriptionField[]";
  }

}