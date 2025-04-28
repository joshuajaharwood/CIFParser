package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

public non-sealed class UicCodeField implements BasicScheduleExtendedField<Integer> {

  UicCodeField() {
  }

  @Override
  public int startIndex() {
    return 6;
  }

  @Override
  public String name() {
    return "UIC_CODE";
  }

  @Override
  public int length() {
    return 5;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Integer convert(String raw) {
    return Integer.valueOf(raw);
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
    return "UicCodeField[]";
  }

}