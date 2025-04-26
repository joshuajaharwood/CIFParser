package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.Association.DiagramType;

public record DiagramTypeField() implements AssociationField<DiagramType> {

  private static final LiteralConverter<DiagramType> CONVERTER = LiteralConverter.create(DiagramType.class);

  @Override
  public int startIndex() {
    return 46;
  }

  @Override
  public String name() {
    return "DIAGRAM_TYPE";
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
  public DiagramType convert(String raw) {
    return CONVERTER.apply(raw);
  }
}
