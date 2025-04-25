package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationCategory;

public record AssociationCategoryField() implements AssociationField<AssociationCategory> {

  @Override
  public int startIndex() {
    return 34;
  }

  @Override
  public String name() {
    return "ASSOCIATION_CATEGORY";
  }

  @Override
  public int length() {
    return 2;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public AssociationCategory convert(String raw) {
    return LiteralConverter.create(AssociationCategory.class).apply(raw);
  }
}