package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.delete;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class TiplocCodeField implements TiplocDeleteField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  TiplocCodeField() {
  }

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "TIPLOC_CODE";
  }

  @Override
  public int length() {
    return 7;
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
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "TiplocCodeField[]";
  }

}