package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;

public record Trailer(String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TRAILER_RECORD;
  }

}
