package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.entry;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringParserTest {

  private static final String HEADER_RECORD = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";
  private static final String BAD_RECORD = "XXTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";
  private static final String SHORT_HEADER_RECORD = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124";

  @Test
  void parsesCorrectly() {
    final var actual = StringParser.parse(HEADER_RECORD, HeaderFields.values());

    assertThat(actual).containsOnly(entry(HeaderFields.RECORD_IDENTITY, "HD"),
        entry(HeaderFields.FILE_IDENTITY, "TPS.UDFROC1.PD231124"),
        entry(HeaderFields.DATE_OF_EXTRACT, "241123"),
        entry(HeaderFields.TIME_OF_EXTRACT, "2032"),
        entry(HeaderFields.CURRENT_FILE_REFERENCE, "DFROC1H"),
        entry(HeaderFields.LAST_FILE_REFERENCE, "       "),
        entry(HeaderFields.UPDATE_INDICATOR, "F"),
        entry(HeaderFields.VERSION, "A"),
        entry(HeaderFields.EXTRACT_START_DATE, "241123"),
        entry(HeaderFields.EXTRACT_END_DATE, "231124"),
        entry(HeaderFields.SPARE, "                    "));
  }

  @Test
  void throwsIllegalArgumentExceptionWhenLengthSumLowerThanRecordLength() {
    List<RowField> tooShort = List.of(new TestRowField(1, "FIELD_1", 2),
        new TestRowField(2, "FIELD_2", 1));

    assertThatIllegalArgumentException().isThrownBy(() -> StringParser.parse("123456", tooShort))
        .withMessage(
            "Given lengths did not sum up to a full record's length. [Given lengths: 2, 1] [Record length: 6]");
  }

  @Test
  void throwsIllegalArgumentExceptionWhenLengthSumHigherThanRecordLength() {
    List<RowField> tooLong = List.of(new TestRowField(1, "FIELD_1", 99),
        new TestRowField(2, "FIELD_2", 99));

    assertThatIllegalArgumentException().isThrownBy(() -> StringParser.parse("123456", tooLong))
        .withMessage(
            "Given lengths did not sum up to a full record's length. [Given lengths: 99, 99] [Record length: 6]");
  }

  @Test
  void parseRecordIdentityWithGoodRecordIdentityReturnsEnum() {
    assertThat(StringParser.parseRecordIdentity(HEADER_RECORD)).isEqualTo(RecordIdentity.HEADER_RECORD);
  }

  @Test
  void parseRecordIdentityWithBadRecordIdentityThrowsIllegalArgumentException() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> StringParser.parseRecordIdentity(
            BAD_RECORD))
        .withMessage(
            "Failed to map String for given StringLiteral. [String: XX] [Enum: RecordIdentity]");
  }

  @Test
  void parseRecordIdentityWithNullRecordThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> StringParser.parseRecordIdentity(null));
  }

  @Test
  void parseRecordIdentityWithShortRecordThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringParser.parseRecordIdentity("A"))
        .withMessage(
            "Given record strings must be at least 2 characters to establish their RecordIdentity.");
  }
}