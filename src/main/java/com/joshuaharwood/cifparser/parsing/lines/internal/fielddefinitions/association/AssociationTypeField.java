package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationType;

public record AssociationTypeField() implements AssociationField<AssociationType> {

  private static final LiteralConverter<AssociationType> CONVERTER = LiteralConverter.create(AssociationType.class);

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
    return true;
  }

  @Override
  public AssociationType convert(String raw) {
    return CONVERTER.apply(raw);
  }
}
