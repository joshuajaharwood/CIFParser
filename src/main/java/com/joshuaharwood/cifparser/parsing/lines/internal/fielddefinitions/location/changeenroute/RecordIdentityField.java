package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;

public record RecordIdentityField() implements ChangeEnRouteField<RecordIdentity> {

  @Override
  public int startIndex() {
    return 0;
  }

  @Override
  public String name() {
    return "RECORD_IDENTITY";
  }

  @Override
  public int length() {
    return 2;
  }

  @Override
  public boolean isRequired() {
    return true;
  }

  @Override
  public RecordIdentity convert(String raw) {
    return LiteralConverter.create(RecordIdentity.class).apply(raw);
  }
}