package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import java.time.LocalDate;
import java.util.function.Function;

public record AssociationStartDateField() implements AssociationField<LocalDate> {

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
  public Function<String, LocalDate> converter() {
    return InverseDateConverter.getInstance();
  }
}