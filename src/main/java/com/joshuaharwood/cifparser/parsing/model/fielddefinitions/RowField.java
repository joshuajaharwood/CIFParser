package com.joshuaharwood.cifparser.parsing.model.fielddefinitions;

public interface RowField {
  int getOrder();

  String getName();

  int getLength();
}
