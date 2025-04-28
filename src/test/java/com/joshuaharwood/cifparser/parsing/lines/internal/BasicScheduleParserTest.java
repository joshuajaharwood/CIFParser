package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.google.common.collect.ImmutableSet;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class BasicScheduleParserTest {

  private static final String TEST_BS_RECORD = "BSRG828851510191510231100100 POO2N75    113575825 DMUE   090      S            O";
  private static final String TEST_BS_RECORD_MISSING_STP_INDICATOR = "BSRG828851510191510231100100 POO2N75    113575825 DMUE   090      S             ";
  private static final String TEST_BS_RECORD_MISSING_TRANSACTION_TYPE = "BS G828851510191510231100100 POO2N75    113575825 DMUE   090      S            O";
  private static final String TEST_BS_RECORD_MISSING_TRAIN_UID = "BSR      1510191510231100100 POO2N75    113575825 DMUE   090      S            O";

  private BasicScheduleParser parser;

  @BeforeEach
  void setUp() {
    parser = new BasicScheduleParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    final var expected = new BasicSchedule(TransactionType.REVISE,
      "G82885",
      LocalDate.of(2015, 10, 19),
      LocalDate.of(2015, 10, 23),
      ImmutableSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.FRIDAY),
      null,
      TrainStatus.PASSENGER_AND_PARCELS_PERMANENT,
      TrainCategory.ORDINARY_PASSENGER,
      "2N75",
      null,
      (byte) 1,
      13575825,
      null,
      PowerType.DIESEL_MECHANICAL_MULTIPLE_UNIT,
      "E",
      90,
      Collections.emptySet(),
      SeatingClass.STANDARD,
      null,
      null,
      null,
      Collections.emptySet(),
      null,
      null,
      StpIndicator.STP_OVERLAY_OF_PERMANENT_ASSOCIATION);

    final var actual = parser.parse(TEST_BS_RECORD);

    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsingWithMissingTrainUidThrowsRequiredPropertyMissingException() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
        TEST_BS_RECORD_MISSING_TRAIN_UID))
      .withMessageContaining(
        "Failed to parse as a required CIF field was blank or null. [Field name: TRAIN_UID]");
  }

  @Test
  void parsingWithMissingTransactionTypeThrowsRequiredPropertyMissingException() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
        TEST_BS_RECORD_MISSING_TRANSACTION_TYPE))
      .withMessageContaining(
        "Failed to parse as a required CIF field was blank or null. [Field name: TRANSACTION_TYPE]");
  }

  @Test
  void parsingWithMissingStpIndicatorThrowsRequiredPropertyMissingException() {
    assertThatExceptionOfType(RequiredPropertyMissingException.class).isThrownBy(() -> parser.parse(
        TEST_BS_RECORD_MISSING_STP_INDICATOR))
      .withMessageContaining(
        "Failed to parse as a required CIF field was blank or null. [Field name: STP_INDICATOR]");
  }

  @Test
  void shouldParseHeadcodeCorrectly() {
    final String headcode = "BSNC185212305212312030000001 BBS0B00RA6 125527005                              P";

    final BasicSchedule actual = parser.parse(headcode);

    

    final var expected = new BasicSchedule(TransactionType.NEW,
      "C18521",
      LocalDate.of(2023, 5, 21),
      LocalDate.of(2023, 12, 3),
      ImmutableSet.of(DayOfWeek.SUNDAY),
      null,
      TrainStatus.BUS_PERMANENT,
      TrainCategory.BUS_WTT_SERVICE,
      "0B00",
      "RA6",
      (byte) 1,
      25527005,
      null,
      null,
      null,
      null,
      Collections.emptySet(),
      null,
      null,
      null,
      null,
      Collections.emptySet(),
      null,
      null,
      StpIndicator.PERMANENT_ASSOCIATION);

    assertThat(actual).isEqualTo(expected);
  }
}