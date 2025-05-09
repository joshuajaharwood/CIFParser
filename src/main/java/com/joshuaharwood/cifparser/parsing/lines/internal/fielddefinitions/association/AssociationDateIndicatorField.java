package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationDateIndicator;

public non-sealed class AssociationDateIndicatorField implements
  AssociationField<AssociationDateIndicator> {

  private static final LiteralConverter<AssociationDateIndicator> CONVERTER = LiteralConverter.create(
    AssociationDateIndicator.class);

  AssociationDateIndicatorField() {
  }

  @Override
  public int startIndex() {
    return 36;
  }

  @Override
  public String name() {
    return "ASSOCIATION_DATE_INDICATOR";
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
  public AssociationDateIndicator convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "AssociationDateIndicatorField[]";
  }

}
