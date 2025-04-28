package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;
import java.util.Optional;

public non-sealed class NlcCheckCharacterField implements TiplocInsertField<Optional<Character>> {

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
  public Optional<Character> convert(String raw) {
    return Optional.of(CONVERTER.apply(raw));
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
    return "NlcCheckCharacterField[]";
  }

}