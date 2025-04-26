package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;

//todo: aka seating class
public final class TrainClassField implements BasicScheduleField<SeatingClass> {

  private static final LiteralConverter<SeatingClass> CONVERTER = LiteralConverter.create(
    SeatingClass.class);

  TrainClassField() {
  }

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
    return "TrainClassField[]";
  }

}
