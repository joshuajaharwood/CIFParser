package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;

public final class CateringCodeField implements ChangeEnRouteField<CateringCode> {

  private static final LiteralConverter<CateringCode> CONVERTER = LiteralConverter.create(
    CateringCode.class);

  CateringCodeField() {
  }

  @Override
  public int startIndex() {
    return 50;
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
  public CateringCode convert(String raw) {
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