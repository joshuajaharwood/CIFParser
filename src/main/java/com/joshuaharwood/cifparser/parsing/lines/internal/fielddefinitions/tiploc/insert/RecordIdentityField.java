package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;

public final class RecordIdentityField implements TiplocInsertField<RecordIdentity> {

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
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "RecordIdentityField[]";
  }

}
