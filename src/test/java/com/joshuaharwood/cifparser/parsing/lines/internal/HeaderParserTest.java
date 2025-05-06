package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class HeaderParserTest {

  private HeaderParser parser;

  @BeforeEach
  public void setUp() {
    parser = new HeaderParser();
  }

  @Test
  void shouldParseWithValidInput() {
    final String input = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";

    final Header expected = new Header("TPS.UDFROC1.PD231124",
        LocalDate.of(2023, 11, 24),
        LocalTime.of(20, 32),
        "DFROC1H",
        null,
        UpdateIndicator.FULL_EXTRACT,
        'A',
        LocalDate.of(2023, 11, 24),
        LocalDate.of(2024, 11, 23),
        null);

    final Header actual = parser.parse(input);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void shouldThrowWhenMissingFileMainframeIdentity() {
    final String badInput = "                      2411232032DFROC1H       FA241123231124                    ";

    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
            badInput))
        .withMessageContaining(
            "Failed to parse as a required CIF field was not populated. [Field name: FILE_MAINFRAME_IDENTITY]");
  }

  @Test
  void shouldThrowWhenMissingCurrentFileReference() {
    final String badInput = "HDTPS.UDFROC1.PD2311242411232032              FA241123231124                    ";

    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
            badInput))
        .withMessageContaining(
            "Failed to parse as a required CIF field was not populated. [Field name: CURRENT_FILE_REFERENCE]");
  }
}