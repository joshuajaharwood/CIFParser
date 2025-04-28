package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;

public non-sealed class NlcCheckCharacterField implements TiplocAmendField<Character> {

  private static final DefaultCharConverter CONVERTER = DefaultCharConverter.getInstance();

  NlcCheckCharacterField() {
  }

  @Override
  public int startIndex() {
    return 17;
  }

  @Override
  public String name() {
    return "NLC_CHECK_CHARACTER";
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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "NlcCheckCharacterField[]";
  }

}