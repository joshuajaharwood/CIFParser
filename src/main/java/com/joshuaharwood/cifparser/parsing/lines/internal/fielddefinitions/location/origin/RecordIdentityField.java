package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.util.function.Function;

public record RecordIdentityField() implements OriginLocationField<RecordIdentity> {

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
  public Function<String, RecordIdentity> converter() {
    return LiteralConverter.create(RecordIdentity.class);
  }
}