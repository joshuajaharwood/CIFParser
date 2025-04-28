package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralSetConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import java.util.Set;

public non-sealed class OperatingCharacteristicsField implements
  ChangeEnRouteField<Set<OperatingCharacteristics>> {

  private static final LiteralSetConverter<OperatingCharacteristics> CONVERTER = LiteralSetConverter.getInstance(
    OperatingCharacteristics.class);

  OperatingCharacteristicsField() {
  }

  @Override
  public int startIndex() {
    return 40;
  }

  @Override
  public String name() {
    return "OPERATING_CHARACTERISTICS";
  }

  @Override
  public int length() {
    return 6;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Set<OperatingCharacteristics> convert(String raw) {
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
    return "OperatingCharacteristicsField[]";
  }

}