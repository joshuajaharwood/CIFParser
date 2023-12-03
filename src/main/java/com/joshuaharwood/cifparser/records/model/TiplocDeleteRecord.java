package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;

public record TiplocDeleteRecord(RecordIdentity recordIdentity, String spare, String tiploc) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }
}
