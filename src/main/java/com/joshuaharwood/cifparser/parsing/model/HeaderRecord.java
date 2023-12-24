package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.model.literals.Literal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record HeaderRecord(String fileMainframeIdentity, LocalDate dateOfExtract,
                           LocalTime timeOfExtract, String currentFileReference,
                           String lastFileReference, UpdateIndicator updateIndicator,
                           Character version, LocalDate userStartDate, LocalDate userEndDate,
                           String spare) implements CIFRecord<HeaderFields> {

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

  @Override
  public List<HeaderFields> fields() {
    return List.of(HeaderFields.values());
  }

  public enum UpdateIndicator implements Literal {
    UPDATE_EXTRACT("U", "Update Extract"),
    FULL_EXTRACT("F", "Full Extract");
    private final String literal;
    private final String description;

    UpdateIndicator(String literal, String description) {
      this.literal = literal;
      this.description = description;
    }

    @Override
    public String toString() {
      return "UpdateIndicator{" + "literal=" + literal + ", description='" + description + '\''
          + '}';
    }

    @Override
    public String getLiteral() {
      return this.literal;
    }
  }

}
