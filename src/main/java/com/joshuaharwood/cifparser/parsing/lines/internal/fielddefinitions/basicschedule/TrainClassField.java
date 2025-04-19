package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.TRAIN_CLASS_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import java.util.function.Function;

public record TrainClassField() implements BasicScheduleField<SeatingClass> {

  @Override
  public int order() {
    return 19;
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
  public Function<String, SeatingClass> converter() {
    return TRAIN_CLASS_CONVERTER;
  }
}
