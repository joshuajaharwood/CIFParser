package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

//todo: how should we structure this?
public class Converter {

  private Converter() {
  }

  public static <T> T convert(RowField<T> rowField, String raw) {
    if (rowField.isRequired() && raw.isBlank()) {
      throw new IllegalArgumentException("Required field '%s' is blank".formatted(rowField.name()));
    }

    return rowField.convert(raw);
  }
}
