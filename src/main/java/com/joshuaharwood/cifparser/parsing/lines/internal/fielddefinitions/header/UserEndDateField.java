package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Function;

public record UserEndDateField() implements HeaderScheduleField<LocalDate> {

  @Override
  public int startIndex() {
    return 54;
  }

  @Override
  public String name() {
    return "USER_END_DATE";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, LocalDate> converter() {
    return DateConverter.getInstance().andThen(Optional::orElseThrow);
  }
}
