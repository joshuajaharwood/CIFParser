package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;

public non-sealed class TrainClassField implements ChangeEnRouteField<SeatingClass> {

  private static final LiteralConverter<SeatingClass> CONVERTER = LiteralConverter.create(
    SeatingClass.class);

  TrainClassField() {
  }

  @Override
  public int startIndex() {
    return 46;
  }

  @Override
  public String name() {
    return "TRAIN_CLASS";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public SeatingClass convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "TrainClassField[]";
  }

}