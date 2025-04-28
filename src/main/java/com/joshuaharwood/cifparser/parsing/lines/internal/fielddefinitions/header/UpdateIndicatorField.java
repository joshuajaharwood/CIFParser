package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;

public non-sealed class UpdateIndicatorField implements HeaderField<UpdateIndicator> {

  private static final LiteralConverter<UpdateIndicator> CONVERTER = LiteralConverter.create(
    UpdateIndicator.class);

  UpdateIndicatorField() {
  }

  @Override
  public int startIndex() {
    return 46;
  }

  @Override
  public String name() {
    return "UPDATE_INDICATOR";
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
  public UpdateIndicator convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "UpdateIndicatorField[]";
  }

}
