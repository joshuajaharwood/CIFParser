package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public record TiplocDelete(RecordIdentity recordIdentity, String spare,
                           String tiploc) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_DELETE_RECORD;
  }

}
