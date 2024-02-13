package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;

public record TiplocDelete(String spare,
                           String tiploc) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_DELETE_RECORD;
  }

}
