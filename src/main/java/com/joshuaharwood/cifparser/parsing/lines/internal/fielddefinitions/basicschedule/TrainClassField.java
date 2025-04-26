package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;

//todo: aka seating class
public record TrainClassField() implements BasicScheduleField<SeatingClass> {

  private static final LiteralConverter<SeatingClass> CONVERTER = LiteralConverter.create(SeatingClass.class);

  @Override
  public int startIndex() {
    return 66;
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
}
