package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record TpsDescriptionField() implements TiplocInsertField<String> {

  @Override
  public int startIndex() {
    return 18;
  }

  @Override
  public String name() {
    return "TPS_DESCRIPTION";
  }

  @Override
  public int length() {
    return 26;
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