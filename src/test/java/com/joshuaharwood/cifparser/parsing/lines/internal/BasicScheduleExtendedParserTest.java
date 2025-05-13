package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicScheduleExtendedParserTest {

  public static final String GOOD_BX_RECORD = "BX         SRY                                                                  ";
  public static final String BX_RECORD_MISSING_APPLICABLE_TIMETABLE_CODE = "BX         SR                                                                   ";
  public static final String BX_RECORD_MISSING_ATOC_CODE = "BX           Y                                                                  ";

  private BasicScheduleExtendedParser parser;

  @BeforeEach
  public void setUp() {
    parser = new BasicScheduleExtendedParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    final var expected = new BasicScheduleExtended(null,
      null,
      "SR",
      ApplicableTimetableCode.APPLICABLE,
      null,
      null,
      null);

    assertThat(parser.parse(GOOD_BX_RECORD)).isEqualTo(expected);
  }

  @Test
  void shouldThrowRequiredPropertyMissingExceptionWhenMissingAtocCode() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(BX_RECORD_MISSING_ATOC_CODE))
      .withMessage("Failed to parse as a required CIF field was not populated. [Field name: ATOC_CODE]");
  }

  @Test
  void shouldThrowRequiredPropertyMissingExceptionWhenMissingApplicableTimetableCode() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
        BX_RECORD_MISSING_APPLICABLE_TIMETABLE_CODE))
      .withMessage("Failed to parse as a required CIF field was not populated. [Field name: APPLICABLE_TIMETABLE_CODE]");
  }
}