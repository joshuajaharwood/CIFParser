package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.fielddefinitions.TiplocDeleteFields;
import java.util.List;

public record TiplocDeleteRecord(RecordIdentity recordIdentity, String spare,
                                 String tiploc) implements TiplocRecord<TiplocDeleteFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }

  @Override
  public List<TiplocDeleteFields> fields() {
    return List.of(TiplocDeleteFields.values());
  }
}
