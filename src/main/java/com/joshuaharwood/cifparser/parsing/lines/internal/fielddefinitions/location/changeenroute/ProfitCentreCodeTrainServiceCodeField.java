package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record ProfitCentreCodeTrainServiceCodeField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 21;
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
  public String convert(String raw) {
    return DefaultStringConverter.getInstance().apply(raw);
  }
}