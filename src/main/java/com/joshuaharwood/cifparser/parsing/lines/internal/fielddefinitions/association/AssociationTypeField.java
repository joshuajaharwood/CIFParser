package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationType;
import java.util.function.Function;

public record AssociationTypeField() implements AssociationField<AssociationType> {

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
  public Function<String, AssociationType> converter() {
    return LiteralConverter.create(AssociationType.class);
  }
}