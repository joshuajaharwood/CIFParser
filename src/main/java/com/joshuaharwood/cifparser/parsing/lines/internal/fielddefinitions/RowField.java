package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

public interface RowField {
  int getOrder();

  String getName();

  int getLength();
}
