package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record FillerField() implements AssociationField<String> {

  @Override
  public int startIndex() {
    return 48;
  }

  @Override
  public String name() {
    return "FILLER";
  }

  @Override
  public int length() {
    return 31;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}