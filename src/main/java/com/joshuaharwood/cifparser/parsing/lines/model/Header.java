package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public record Header(String fileMainframeIdentity, LocalDate dateOfExtract,
                     LocalTime timeOfExtract, String currentFileReference,
                     String lastFileReference, UpdateIndicator updateIndicator,
                     Character version, LocalDate userStartDate, LocalDate userEndDate,
                     @Nullable String spare) implements CifRecord {

  public Header {
    if (!Character.isUpperCase(version)) {
      throw new IllegalArgumentException(
          "A non-capital-alphanumeric Version property was passed as an argument. [Version: %s]".formatted(
              version));
    }
  }

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.HEADER_RECORD;
  }

}
