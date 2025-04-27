package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import java.util.Optional;

public final class PoMcpCodeField implements TiplocInsertField<Optional<Integer>> {

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
  public Optional<Integer> convert(String raw) {
    return s -> {
      if (s == null || s.isBlank()) {
        return Optional.empty();
      }
      try {
        return Optional.of(Integer.valueOf(s.trim()));
      } catch (NumberFormatException e) {
        return Optional.empty();
      }
    };
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "PoMcpCodeField[]";
  }

}