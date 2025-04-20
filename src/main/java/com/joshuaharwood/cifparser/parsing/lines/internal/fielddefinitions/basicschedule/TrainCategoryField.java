package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import java.util.function.Function;

public record TrainCategoryField() implements BasicScheduleField<TrainCategory> {
  @Override
  public int startIndex() {
    return 30;
  }

  @Override
  public String name() {
    return "TRAIN_CATEGORY";
  }

  @Override
  public int length() {
    return 2;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, TrainCategory> converter() {
    return LiteralConverter.create(TrainCategory.class);
  }
}
