//package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;
//
//public enum TrailerFields implements RowField {
//  RECORD_IDENTITY(1, 2),
//  SPARE(2, 78);
//
//  private final int order;
//  private final int length;
//
//  TrailerFields(int order, int length) {
//    this.order = order;
//    this.length = length;
//  }
//
//  @Override
//  public int order() {
//    return order;
//  }
//
//  @Override
//  public String name() {
//    return toString();
//  }
//
//  @Override
//  public int length() {
//    return length;
//  }
//}
