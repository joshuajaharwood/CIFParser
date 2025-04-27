package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public interface RowField<T> {

  int startIndex();

  String name();

  int length();

  boolean isRequired();

  T convert(String raw);

  default int endIndex() {
    return startIndex() + length();
  }
}
