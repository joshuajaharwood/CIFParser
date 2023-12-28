package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;

@SuppressWarnings("ClassCanBeRecord")
public class TestRowField implements RowField {

  private final int order;
  private final String name;
  private final int length;

  public TestRowField(int order, String name, int length) {
    this.order = order;
    this.name = name;
    this.length = length;
  }

  @Override
  public int getOrder() {
    return order;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getLength() {
    return length;
  }
}
