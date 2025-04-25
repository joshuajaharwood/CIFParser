package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;

public record TransactionTypeField() implements AssociationField<TransactionType> {

  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "TRANSACTION_TYPE";
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
  public TransactionType convert(String raw) {
    return LiteralConverter.create(TransactionType.class).apply(raw);
  }
}