package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public interface RowField<R> {

  int startIndex();

  String name();

  int length();

  boolean isRequired();

  R convert(String raw);

  default R substringAndConvert(String record) {
    return convert(record.substring(startIndex(), endIndex()));
  }

  default int endIndex() {
    return startIndex() + length();
  }
}
