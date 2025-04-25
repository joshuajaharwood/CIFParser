package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import java.util.function.Function;

public record PoMcpCodeField() implements TiplocAmendField<Integer> {

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
  public Function<String, Integer> converter() {
    return s -> {
      if (s == null || s.isBlank()) {
        return null;
      }
      return Integer.valueOf(s);
    };
  }
}