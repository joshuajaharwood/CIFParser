package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import java.util.function.Function;

public record RetailServiceIdField() implements BasicScheduleExtendedField<String> {

  @Override
  public int startIndex() {
    return 14;
  }

  @Override
  public String name() {
    return "RETAIL_SERVICE_ID";
  }

  @Override
  public int length() {
    return 8;
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