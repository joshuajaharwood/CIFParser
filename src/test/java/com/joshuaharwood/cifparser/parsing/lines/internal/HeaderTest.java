package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class HeaderTest {

  @SuppressWarnings("DataFlowIssue")
  @Test
  void versionCannotBeNull() {
    assertThatNullPointerException().isThrownBy(() -> new Header("fileMainframeIdentity",
      LocalDate.of(2000, 1, 1),
      LocalTime.of(12, 0, 0),
      "currentFileReference",
      "lastFileReference",
      UpdateIndicator.UPDATE_EXTRACT,
      null,
      LocalDate.of(2000, 1, 1),
      LocalDate.of(2000, 1, 1),
      null));
  }

  @Test
  void versionCannotBeLowercase() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Header("fileMainframeIdentity",
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
    assertThatIllegalArgumentException().isThrownBy(() -> new Header("fileMainframeIdentity",
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
    assertThatIllegalArgumentException().isThrownBy(() -> new Header("fileMainframeIdentity",
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
    var headerRecord = new Header("fileMainframeIdentity",
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