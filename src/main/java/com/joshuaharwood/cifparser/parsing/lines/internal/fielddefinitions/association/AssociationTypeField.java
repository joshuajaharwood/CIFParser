package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationType;

public non-sealed class AssociationTypeField implements AssociationField<AssociationType> {

  private static final LiteralConverter<AssociationType> CONVERTER = LiteralConverter.create(
    AssociationType.class);

  AssociationTypeField() {
  }

  @Override
  public int startIndex() {
    return 47;
  }

  @Override
  public String name() {
    return "ASSOCIATION_TYPE";
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
  public AssociationType convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "AssociationTypeField[]";
  }

}
