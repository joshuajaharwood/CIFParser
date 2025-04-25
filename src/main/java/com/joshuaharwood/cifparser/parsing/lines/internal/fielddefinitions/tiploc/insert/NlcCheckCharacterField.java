package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;
import java.util.Optional;

public record NlcCheckCharacterField() implements TiplocInsertField<Optional<Character>> {

  private static final DefaultCharConverter DEFAULT_CHAR_CONVERTER = DefaultCharConverter.getInstance();

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
    return Optional.ofNullable(DEFAULT_CHAR_CONVERTER.apply(raw));
  }
}