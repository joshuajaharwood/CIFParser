package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class FileMainframeIdentityField implements HeaderField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  FileMainframeIdentityField() {
  }

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "FILE_MAINFRAME_IDENTITY";
  }

  @Override
  public int length() {
    return 20;
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
  public String toString() {
    return "FileMainframeIdentityField[]";
  }

}