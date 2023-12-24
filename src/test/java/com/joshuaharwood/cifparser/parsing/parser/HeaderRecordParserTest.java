package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class HeaderRecordParserTest {

  private HeaderRecordParser parser;

  @BeforeEach
  public void setUp() {
    parser = new HeaderRecordParser();
  }

  @Test
  void parse() {
    final String input = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";

    final HeaderRecord expected = new HeaderRecord("TPS.UDFROC1.PD231124",
        LocalDate.of(2023, 11, 24),
        LocalTime.of(20, 32),
        "DFROC1H",
        null,
        UpdateIndicator.FULL_EXTRACT,
        'A',
        LocalDate.of(2023, 11, 24),
        LocalDate.of(2024, 11, 23),
        null);

    final HeaderRecord actual = parser.parse(input);

    assertThat(actual).isEqualTo(expected);
  }
}