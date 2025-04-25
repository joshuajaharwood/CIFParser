package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record TrainCategoryField() implements ChangeEnRouteField<String> {

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
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}