package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

public record VersionField() implements HeaderField<Character> {

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
    return DefaultCharConverter.getInstance().apply(raw);
  }
}
