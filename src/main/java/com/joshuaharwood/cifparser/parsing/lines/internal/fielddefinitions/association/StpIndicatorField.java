package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;

public record StpIndicatorField() implements AssociationField<StpIndicator> {

  @Override
  public int startIndex() {
    return 79;
  }

  @Override
  public String name() {
    return "STP_INDICATOR";
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
  public StpIndicator convert(String raw) {
    return LiteralConverter.create(StpIndicator.class).apply(raw);
  }
}