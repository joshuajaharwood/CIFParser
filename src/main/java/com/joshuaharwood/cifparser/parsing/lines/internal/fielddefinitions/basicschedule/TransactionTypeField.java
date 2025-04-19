package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.TRANSACTION_TYPE_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.util.function.Function;

public record TransactionTypeField() implements BasicScheduleField<TransactionType> {

  @Override
  public int order() {
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
  public Function<String, TransactionType> converter() {
    return TRANSACTION_TYPE_CONVERTER;
  }
}
