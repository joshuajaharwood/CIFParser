package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralSetConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import java.util.Set;

public final class CateringCodeField implements BasicScheduleField<Set<CateringCode>> {

  private static final LiteralSetConverter<CateringCode> CONVERTER = LiteralSetConverter.getInstance(
    CateringCode.class);

  CateringCodeField() {
  }

  @Override
  public int startIndex() {
    return 70;
  }

  @Override
  public String name() {
    return "CATERING_CODE";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Set<CateringCode> convert(String raw) {
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "CateringCodeField[]";
  }

}
