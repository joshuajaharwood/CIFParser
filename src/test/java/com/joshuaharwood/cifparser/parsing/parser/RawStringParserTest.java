package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import java.util.List;
import org.junit.jupiter.api.Test;

class RawStringParserTest {
  RawStringParser<HeaderFields> headerParser = new RawStringParser<>(HeaderFields.values(), HeaderFields.class);

  private static final String HEADER_RECORD = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";
  private static final String BAD_RECORD = "XXTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";
  private static final String SHORT_HEADER_RECORD = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";

  private static final RawStringParser<HeaderFields> parser = new RawStringParser<>(HeaderFields.values(), HeaderFields.class);

  @Test
  void parsesCorrectly() {
    final var expected = List.of("HD",
        "TPS.UDFROC1.PD231124",
        "241123",
        "2032",
        "DFROC1H",
        "       ",
        "F",
        "A",
        "241123",
        "231124",
        "                    ");
    final var actual = RawStringParser.parse(HEADER_RECORD,
        HeaderRecord.class);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void throwsIllegalArgumentExceptionWhenLengthSumLowerThanRecordLength() {
    assertThatIllegalArgumentException().isThrownBy(() -> RawStringParser.parse("123456",
            List.of(2, 1)))
        .withMessage(
            "Given lengths did not sum up to a full record's length. [Given lengths: 2, 1] [Record length: 6]");
  }

  @Test
  void throwsIllegalArgumentExceptionWhenLengthSumHigherThanRecordLength() {
    assertThatIllegalArgumentException().isThrownBy(() -> RawStringParser.parse("123456",
            List.of(99, 99)))
        .withMessage(
            "Given lengths did not sum up to a full record's length. [Given lengths: 99, 99] [Record length: 6]");
  }

  @Test
  void parseRecordIdentityWithGoodRecordIdentityReturnsEnum() {
    assertThat(RawStringParser.parseRecordIdentity(HEADER_RECORD)).contains(RecordIdentity.HEADER_RECORD);
  }

  @Test
  void parseRecordIdentityWithBadRecordIdentityThrowsIllegalArgumentException() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> RawStringParser.parseRecordIdentity(
        BAD_RECORD)).withMessage("Failed to map String for given StringLiteral. [String: XX] [Enum: RecordIdentity]");
  }

  @Test
  void parseRecordIdentityWithNullRecordThrowsNullPointerException() {
    assertThatNullPointerException().isThrownBy(() -> RawStringParser.parseRecordIdentity(null));
  }

  @Test
  void parseRecordIdentityWithShortRecordThrowsIllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> RawStringParser.parseRecordIdentity("A"))
        .withMessage(
            "Given record strings must be at least 2 characters to establish their RecordIdentity.");
  }
}