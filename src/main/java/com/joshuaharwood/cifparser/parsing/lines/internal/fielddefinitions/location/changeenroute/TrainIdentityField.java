package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public record TrainIdentityField() implements ChangeEnRouteField<String> {

  @Override
  public int startIndex() {
    return 12;
  }

  @Override
  public String name() {
    return "TRAIN_IDENTITY";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public String convert(String raw) {
    return CONVERTER.apply(raw);
  }
}