package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import java.util.function.Function;

//todo: AKA train service code
public record ProfitCentreCodeField() implements BasicScheduleField<Integer> {

  @Override
  public int startIndex() {
    return 41;
  }

  @Override
  public String name() {
    return "PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE";
  }

  @Override
  public int length() {
    return 8;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, Integer> converter() {
    return Integer::valueOf;
  }
}
