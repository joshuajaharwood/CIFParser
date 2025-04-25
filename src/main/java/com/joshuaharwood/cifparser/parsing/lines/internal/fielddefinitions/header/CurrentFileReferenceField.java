package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record CurrentFileReferenceField() implements HeaderField<String> {

  @Override
  public int startIndex() {
    return 32;
  }

  @Override
  public String name() {
    return "CURRENT_FILE_REFERENCE";
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
    return DefaultStringConverter.getInstance().apply(raw);
  }
}
