package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;

public non-sealed class AssociationStartDateField implements AssociationField<LocalDate> {

  private static final InverseDateConverter CONVERTER = InverseDateConverter.getInstance();

  AssociationStartDateField() {
  }

  @Override
  public int startIndex() {
    return 15;
  }

  @Override
  public String name() {
    return "ASSOCIATION_START_DATE";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public LocalDate convert(String raw) {
    return CONVERTER.apply(raw);
  }

  @Override
  public String toString() {
    return "AssociationStartDateField[]";
  }

}
