package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public record Trailer(String spare) implements CIFRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TRAILER_RECORD;
  }

}
