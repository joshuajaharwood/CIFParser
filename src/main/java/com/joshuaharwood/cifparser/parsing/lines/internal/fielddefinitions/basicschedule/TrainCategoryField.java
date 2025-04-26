package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;

public record TrainCategoryField() implements BasicScheduleField<TrainCategory> {

  private static final LiteralConverter<TrainCategory> CONVERTER = LiteralConverter.create(TrainCategory.class);

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
  public TrainCategory convert(String raw) {
    return CONVERTER.apply(raw);
  }
}
