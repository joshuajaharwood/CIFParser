package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.NullUnmarked;
import org.jspecify.annotations.Nullable;

public record Trailer(@Nullable String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TRAILER_RECORD;
  }
}