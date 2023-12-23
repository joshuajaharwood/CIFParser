package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.fielddefinitions.TrailerFields;
import java.util.List;

public record TrailerRecord(String spare) implements CIFRecord<TrailerFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TRAILER_RECORD;
  }

  @Override
  public List<TrailerFields> fields() {
    return List.of(TrailerFields.values());
  }
}
