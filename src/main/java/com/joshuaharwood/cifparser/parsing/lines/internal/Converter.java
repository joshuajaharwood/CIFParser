package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

//todo: how should we structure this?
public class Converter {
  private Converter() {
  }

  public static <T> T convert(RowField<T> v, String record) {
    return v.convertTemp(record.substring(v.startIndex(), v.endIndex()));
  }
}
