package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import java.time.DayOfWeek;
import java.util.Set;

public record AssociationDaysField() implements AssociationField<Set<DayOfWeek>> {

  @Override
  public int startIndex() {
    return 27;
  }

  @Override
  public String name() {
    return "ASSOCIATION_DAYS";
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
  public Set<DayOfWeek> convert(String raw) {
    return DaysOfWeekBitmaskConverter.getInstance().apply(raw);
  }
}