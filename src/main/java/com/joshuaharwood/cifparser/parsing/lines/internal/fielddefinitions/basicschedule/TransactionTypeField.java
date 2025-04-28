package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;

public non-sealed class TransactionTypeField implements BasicScheduleField<TransactionType> {

  private static final LiteralConverter<TransactionType> CONVERTER = LiteralConverter.create(
    TransactionType.class);

  TransactionTypeField() {
  }

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
    return "TransactionTypeField[]";
  }

}
