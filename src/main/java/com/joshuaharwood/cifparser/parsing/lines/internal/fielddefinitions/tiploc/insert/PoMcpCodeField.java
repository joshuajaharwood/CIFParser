package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class PoMcpCodeField implements TiplocInsertField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  PoMcpCodeField() {
  }

  @Override
  public int startIndex() {
    return 49;
  }

  @Override
  public String name() {
    return "PO_MCP_CODE";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public String convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "PoMcpCodeField[]";
  }
}