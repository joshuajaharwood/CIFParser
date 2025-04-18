package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

import java.util.function.Function;

public interface RowField<T> {
  int order();

  String name();

  int length();
  
  boolean isRequired();

  Function<String, T> getConverter();
}
