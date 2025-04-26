package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationCategory;

public final class AssociationCategoryField implements AssociationField<AssociationCategory> {

  private static final LiteralConverter<AssociationCategory> CONVERTER = LiteralConverter.create(
    AssociationCategory.class);

  AssociationCategoryField() {
  }

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
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "AssociationCategoryField[]";
  }

}
