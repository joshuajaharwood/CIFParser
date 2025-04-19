package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.TRAIN_STATUS_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus;
import java.util.function.Function;

public record TrainStatusField() implements BasicScheduleField<TrainStatus> {

  @Override
  public int order() {
    return 8;
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
  public Function<String, TrainStatus> converter() {
    return TRAIN_STATUS_CONVERTER;
  }
}
