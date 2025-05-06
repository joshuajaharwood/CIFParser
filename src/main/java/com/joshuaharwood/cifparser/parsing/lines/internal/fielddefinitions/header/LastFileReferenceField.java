package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class LastFileReferenceField implements HeaderField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  LastFileReferenceField() {
  }

  @Override
  public int startIndex() {
    return 39;
  }

  @Override
  public String name() {
    return "LAST_FILE_REFERENCE";
  }

  @Override
  public int length() {
    return 7;
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
  public String toString() {
    return "LastFileReferenceField[]";
  }

}
