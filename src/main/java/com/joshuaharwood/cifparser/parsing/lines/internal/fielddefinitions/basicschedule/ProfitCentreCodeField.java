package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import java.util.function.Function;

public record ProfitCentreCodeField() implements BasicScheduleField<Integer> {

  @Override
  public int order() {
    return 13;
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
