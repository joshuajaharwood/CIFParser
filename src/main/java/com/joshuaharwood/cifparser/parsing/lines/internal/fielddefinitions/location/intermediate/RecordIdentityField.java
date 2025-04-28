package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;

public non-sealed class RecordIdentityField implements IntermediateLocationField<RecordIdentity> {

  private static final LiteralConverter<RecordIdentity> CONVERTER = LiteralConverter.create(
    RecordIdentity.class);

  RecordIdentityField() {
  }

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
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "RecordIdentityField[]";
  }

}
