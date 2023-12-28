package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TiplocDeleteFields;

public record TiplocDeleteRecord(RecordIdentity recordIdentity, String spare,
                                 String tiploc) implements TiplocRecord<TiplocDeleteFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_DELETE_RECORD;
  }

}
