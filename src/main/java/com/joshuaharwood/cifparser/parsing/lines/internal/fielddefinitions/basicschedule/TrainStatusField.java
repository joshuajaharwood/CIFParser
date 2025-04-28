package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;

public non-sealed class TrainStatusField implements BasicScheduleField<TrainStatus> {

  private static final LiteralConverter<TrainStatus> CONVERTER = LiteralConverter.create(TrainStatus.class);

  TrainStatusField() {
  }

  @Override
  public int startIndex() {
    return 29;
  }

  @Override
  public String name() {
    return "TRAIN_STATUS";
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
  public TrainStatus convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "TrainStatusField[]";
  }

}
