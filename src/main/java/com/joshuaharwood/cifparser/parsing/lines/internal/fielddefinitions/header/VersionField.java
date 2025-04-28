package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

public non-sealed class VersionField implements HeaderField<Character> {

  private static final DefaultCharConverter CONVERTER = DefaultCharConverter.getInstance();

  VersionField() {
  }

  @Override
  public int startIndex() {
    return 47;
  }

  @Override
  public String name() {
    return "VERSION";
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
  public Character convert(String raw) {
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
    return "VersionField[]";
  }

}
