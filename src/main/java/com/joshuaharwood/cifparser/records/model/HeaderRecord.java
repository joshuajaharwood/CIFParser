package com.joshuaharwood.cifparser.records.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record HeaderRecord(String fileMainframeIdentity, LocalDate dateOfExtract,
                           LocalTime timeOfExtract, String currentFileReference,
                           String lastFileReference, UpdateIndicator updateIndicator,
                           Character version, LocalDate userStartDate, LocalDate userEndDate,
                           String spare) implements CIFRecord {

  public HeaderRecord {
    if (version == null || !Character.isUpperCase(version)) {
      throw new IllegalArgumentException(
          "A non-capital-alphanumeric Version property was passed as an argument. [Version: %s]".formatted(
              version));
    }
  }

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.HEADER_RECORD;
  }

  public enum UpdateIndicator {
    UPDATE_EXTRACT('U', "Update Extract"), FULL_EXTRACT('F', "Full Extract");
    private final char literal;
    private final String description;

    UpdateIndicator(char literal, String description) {
      this.literal = literal;
      this.description = description;
    }

    @Override
    public String toString() {
      return "UpdateIndicator{" + "literal=" + literal + ", description='" + description + '\''
          + '}';
    }
  }
}
