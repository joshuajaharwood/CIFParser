package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class PathField implements TerminatingLocationField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  PathField() {
  }

  @Override
  public int startIndex() {
    return 22;
  }

  @Override
  public String name() {
    return "PATH";
  }

  @Override
  public int length() {
    return 3;
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
    return "PathField[]";
  }

}