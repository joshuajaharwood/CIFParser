package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

import java.util.function.Function;

public interface RowField<T> {

  int order();

  String name();

  int length();

  boolean isRequired();

  Function<String, T> converter();

  default T convert(String raw) {
    if (isRequired() && raw.isBlank()) {
      //TODO: improve exception message
      throw new IllegalArgumentException("Required field '" + name() + "' is blank");
    }

    return converter().apply(raw);
  }
}
