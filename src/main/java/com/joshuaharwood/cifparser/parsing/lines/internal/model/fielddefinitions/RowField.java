package com.joshuaharwood.cifparser.parsing.lines.internal.model.fielddefinitions;

public interface RowField {
  int getOrder();

  String getName();

  int getLength();
}
