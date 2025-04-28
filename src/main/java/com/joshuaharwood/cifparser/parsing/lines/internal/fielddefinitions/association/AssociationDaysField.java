package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import java.time.DayOfWeek;
import java.util.Set;

public non-sealed class AssociationDaysField implements AssociationField<Set<DayOfWeek>> {

  private static final DaysOfWeekBitmaskConverter CONVERTER = DaysOfWeekBitmaskConverter.getInstance();

  AssociationDaysField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "AssociationDaysField[]";
  }

}
