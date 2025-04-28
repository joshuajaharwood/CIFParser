package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;

public non-sealed class TrainCategoryField implements ChangeEnRouteField<TrainCategory> {

  private static final LiteralConverter<TrainCategory> CONVERTER = LiteralConverter.create(
    TrainCategory.class);

  TrainCategoryField() {
  }

  @Override
  public int startIndex() {
    return 10;
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


  @Override
  public String toString() {
    return "TrainCategoryField[]";
  }

}