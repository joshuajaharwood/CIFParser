package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

//todo: AKA train service code
public non-sealed class ProfitCentreCodeField implements BasicScheduleField<Integer> {

  ProfitCentreCodeField() {
  }

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
  public Integer convert(String raw) {
    return Integer.valueOf(raw);
  }


  @Override
  public String toString() {
    return "ProfitCentreCodeField[]";
  }

}
