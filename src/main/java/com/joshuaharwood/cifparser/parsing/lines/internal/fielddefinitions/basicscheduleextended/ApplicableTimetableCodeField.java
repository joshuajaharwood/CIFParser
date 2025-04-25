package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.ApplicableTimetableCode;
import java.util.function.Function;

public record ApplicableTimetableCodeField() implements BasicScheduleExtendedField<ApplicableTimetableCode> {

  @Override
  public int startIndex() {
    return 13;
  }

  @Override
  public String name() {
    return "APPLICABLE_TIMETABLE_CODE";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public Function<String, ApplicableTimetableCode> converter() {
    return LiteralConverter.create(ApplicableTimetableCode.class);
  }
}