package com.joshuaharwood.cifparser.records;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.records.model.HeaderRecord;
import com.joshuaharwood.cifparser.records.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.records.model.RecordIdentity;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class HeaderRecordTest {

  @Test
  void versionCannotBeNull() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new HeaderRecord("fileMainframeIdentity",
          LocalDate.of(2000, 1, 1),
          LocalTime.of(12, 0, 0),
          "currentFileReference",
          "lastFileReference",
          UpdateIndicator.UPDATE_EXTRACT,
          null,
          LocalDate.of(2000, 1, 1),
          LocalDate.of(2000, 1, 1),
          null);
    });
  }

  @Test
  void versionCannotBeLowercase() {
    assertThatIllegalArgumentException().isThrownBy(() -> new HeaderRecord("fileMainframeIdentity",
        LocalDate.of(2000, 1, 1),
        LocalTime.of(12, 0, 0),
        "currentFileReference",
        "lastFileReference",
        UpdateIndicator.UPDATE_EXTRACT,
        'a',
        LocalDate.of(2000, 1, 1),
        LocalDate.of(2000, 1, 1),
        null));
  }

  @Test
  void versionCannotBeSpace() {
    assertThatIllegalArgumentException().isThrownBy(() -> new HeaderRecord("fileMainframeIdentity",
        LocalDate.of(2000, 1, 1),
        LocalTime.of(12, 0, 0),
        "currentFileReference",
        "lastFileReference",
        UpdateIndicator.UPDATE_EXTRACT,
        ' ',
        LocalDate.of(2000, 1, 1),
        LocalDate.of(2000, 1, 1),
        null));
  }

  @Test
  void versionCannotBeNumeric() {
    assertThatIllegalArgumentException().isThrownBy(() -> new HeaderRecord("fileMainframeIdentity",
        LocalDate.of(2000, 1, 1),
        LocalTime.of(12, 0, 0),
        "currentFileReference",
        "lastFileReference",
        UpdateIndicator.UPDATE_EXTRACT,
        '1',
        LocalDate.of(2000, 1, 1),
        LocalDate.of(2000, 1, 1),
        null));
  }

  @Test
  void shouldReturnCorrectRecordIdentity() {
    var headerRecord = new HeaderRecord("fileMainframeIdentity",
        LocalDate.of(2000, 1, 1),
        LocalTime.of(12, 0, 0),
        "currentFileReference",
        "lastFileReference",
        UpdateIndicator.UPDATE_EXTRACT,
        'A',
        LocalDate.of(2000, 1, 1),
        LocalDate.of(2000, 1, 1),
        null);

    assertThat(headerRecord.recordIdentity()).isEqualTo(RecordIdentity.HEADER_RECORD);
  }
}