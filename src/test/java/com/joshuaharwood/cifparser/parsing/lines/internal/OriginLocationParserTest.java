package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class OriginLocationParserTest {

  public static final String GOOD_LO_RECORD = "LOGLGQHL  1703 17033  UEG    TB                                                 ";
  public static final String GOOD_LO_RECORD_WITH_ZERO_PUBLIC_DEPARTURE_TIME = "LOGLGQHL  1703 00003  UEG    TB                                                 ";
  public static final String LO_RECORD_MISSING_LOCATION = "LO        1703 17033  UEG    TB                                                 ";
  private OriginLocationParser parser;

  @BeforeEach
  public void setUp() {
    parser = new OriginLocationParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    final var expected = new OriginLocation("GLGQHL",
        LocalTime.of(17, 3),
        LocalTime.of(17, 3),
        "3",
        "UEG",
        null,
        null,
        "TB",
        null,
        null);

    assertThat(parser.parse(GOOD_LO_RECORD)).isEqualTo(expected);
  }

  @Test
  void parsingDataMissingLocationThrowsRequiredPropertyMissingException() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class)
        .isThrownBy(() -> parser.parse(LO_RECORD_MISSING_LOCATION))
        .withMessageContaining(
            "Failed to parse as a required CIF field was not populated. [Field name: LOCATION]");
  }

  @Test
  void parsesPublicDepartureTimeOfZeroToNull() {
    final var expected = new OriginLocation("GLGQHL",
        LocalTime.of(17, 3),
        null,
        "3",
        "UEG",
        null,
        null,
        "TB",
        null,
        null);

    assertThat(parser.parse(GOOD_LO_RECORD_WITH_ZERO_PUBLIC_DEPARTURE_TIME))

        .isEqualTo(expected);
  }
}