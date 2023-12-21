package com.joshuaharwood.cifparser.records.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;

class RawStringParserTest {

  @Test
  void parsesCorrectly() {
    final String input = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";

    final var expected = List.of("TPS.UDFROC1.PD231124",
        "241123",
        "2032",
        "DFROC1H",
        "       ",
        "F",
        "A",
        "241123",
        "231124",
        "                    ");
    final var actual = RawStringParser.parse(input, HeaderRecordParser.HEADER_RECORD_LENGTHS);

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
}