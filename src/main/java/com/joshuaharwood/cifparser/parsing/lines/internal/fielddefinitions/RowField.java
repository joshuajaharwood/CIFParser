package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

import java.util.function.Function;

public interface RowField<T> {

  int startIndex();

  String name();

  int length();

  boolean isRequired();

  Function<String, T> converter();

  default T convert(String raw) {
    if (isRequired() && raw.isBlank()) {
      throw new IllegalArgumentException("Required field '%s' is blank".formatted(name()));
    }

    return converter().apply(raw);
  }

  default int endIndex() {
    return startIndex() + length();
  }
}
