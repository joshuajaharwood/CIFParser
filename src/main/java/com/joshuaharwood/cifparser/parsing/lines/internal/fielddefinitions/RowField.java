package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public interface RowField<R> {

  int startIndex();

  String name();

  int length();

  boolean isRequired();

  R convert(String raw);

  default R substringAndConvert(String record) {
    var rawField = record.substring(startIndex(), endIndex());

    if (rawField.isBlank()) {
      if (isRequired()) {
        throw new IllegalArgumentException("Record is blank for required field " + name());
      }

      return null;
    }

    return convert(rawField);
  }

  default int endIndex() {
    return startIndex() + length();
  }
}
