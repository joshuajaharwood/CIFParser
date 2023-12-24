package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TrailerFields;
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
