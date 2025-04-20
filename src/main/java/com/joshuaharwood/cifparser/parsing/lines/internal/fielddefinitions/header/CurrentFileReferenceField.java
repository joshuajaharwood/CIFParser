package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

public record CurrentFileReferenceField() implements HeaderScheduleField<String> {

  @Override
  public int startIndex() {
    return 32;
  }

  @Override
  public String name() {
    return "CURRENT_FILE_REFERENCE";
  }

  @Override
  public int length() {
    return 7;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}
