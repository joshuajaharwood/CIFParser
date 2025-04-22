package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.NullUnmarked;
import org.jspecify.annotations.Nullable;

public record Trailer(@Nullable String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TRAILER_RECORD;
  }

  @NullUnmarked
  public static class Builder {

    private @Nullable String spare;

    public Trailer.Builder setSpare(@Nullable String spare) {
      this.spare = spare;
      return this;
    }

    public Trailer createTrailer() {
      return new Trailer(spare);
    }
  }
}