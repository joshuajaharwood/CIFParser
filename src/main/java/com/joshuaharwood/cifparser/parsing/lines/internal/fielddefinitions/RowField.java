package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public interface RowField<T> {

  int startIndex();

  String name();

  int length();

  boolean isRequired();

  T convert(String raw);

  default T convertTemp(String raw) {
    if (isRequired() && raw.isBlank()) {
      throw new IllegalArgumentException("Required field '%s' is blank".formatted(name()));
    }

    return convert(raw);
  }

  default int endIndex() {
    return startIndex() + length();
  }
}
