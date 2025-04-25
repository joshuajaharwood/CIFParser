package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationDateIndicator;
import java.util.function.Function;

public record AssociationDateIndicatorField() implements AssociationField<AssociationDateIndicator> {

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
    return true;
  }

  @Override
  public Function<String, AssociationDateIndicator> converter() {
    return LiteralConverter.create(AssociationDateIndicator.class);
  }
}