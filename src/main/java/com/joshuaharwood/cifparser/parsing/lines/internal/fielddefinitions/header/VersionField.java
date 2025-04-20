package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultCharConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Header.UpdateIndicator;
import java.util.function.Function;

public record VersionField() implements HeaderScheduleField<Character> {

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
