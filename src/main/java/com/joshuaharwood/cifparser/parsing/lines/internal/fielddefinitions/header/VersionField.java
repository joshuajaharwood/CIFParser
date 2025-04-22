package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;
import java.util.function.Function;

public record VersionField() implements HeaderField<Character> {

  @Override
  public int startIndex() {
    return 47;
  }

  @Override
  public String name() {
    return "VERSION";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, Character> converter() {
    return DefaultCharConverter.getInstance();
  }
}
