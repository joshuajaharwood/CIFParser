package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

public non-sealed class SourceField implements BasicScheduleExtendedField<Character> {

  SourceField() {
  }

  @Override
  public int startIndex() {
    return 22;
  }

  @Override
  public String name() {
    return "SOURCE";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Character convert(String raw) {
    return raw.charAt(0);
  }


  @Override
  public String toString() {
    return "SourceField[]";
  }

}