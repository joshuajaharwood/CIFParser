package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.google.common.collect.ImmutableSet;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.Builder;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
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
    final var expected = new Builder().setTransactionType(TransactionType.REVISE)
      .setTrainUid("G82885")
      .setDateRunsFrom(LocalDate.of(2015, 10, 19))
      .setDateRunsTo(LocalDate.of(2015, 10, 23))
      .setDaysRun(ImmutableSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.FRIDAY))
      .setBankHolidayRunning(null)
      .setTrainStatus(TrainStatus.PASSENGER_AND_PARCELS_PERMANENT)
      .setTrainCategory(TrainCategory.ORDINARY_PASSENGER)
      .setTrainIdentity("2N75")
      .setHeadcode(null)
      .setCourseIndicator((byte) 1)
      .setTrainServiceCode(13575825)
      .setPortionId(null)
      .setPowerType(PowerType.DIESEL_MECHANICAL_MULTIPLE_UNIT)
      .setTimingLoad("E")
      .setSpeed(90)
      .setOperatingCharacteristics(Collections.emptySet())
      .setSeatingClass(SeatingClass.STANDARD)
      .setSleepers(null)
      .setReservations(null)
      .setConnectionIndicator(null)
      .setCateringCode(Collections.emptySet())
      .setServiceBranding(null)
      .setStpIndicator(StpIndicator.STP_OVERLAY_OF_PERMANENT_ASSOCIATION)
      .setSpare(null)
      .createBasicSchedule();

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

    final BasicSchedule expected = new Builder().setTransactionType(TransactionType.NEW)
      .setTrainUid("C18521")
      .setDateRunsFrom(LocalDate.of(2023, 5, 21))
      .setDateRunsTo(LocalDate.of(2023, 12, 3))
      .setDaysRun(Set.of(DayOfWeek.SUNDAY))
      .setBankHolidayRunning(null)
      .setTrainStatus(TrainStatus.BUS_PERMANENT)
      .setTrainCategory(TrainCategory.BUS_WTT_SERVICE)
      .setTrainIdentity("0B00")
      .setHeadcode("RA6")
      .setCourseIndicator((byte) 1)
      .setTrainServiceCode(25527005)
      .setPortionId(null)
      .setPowerType(null)
      .setTimingLoad(null)
      .setSpeed(null)
      .setOperatingCharacteristics(Collections.emptySet())
      .setSeatingClass(null)
      .setSleepers(null)
      .setReservations(null)
      .setConnectionIndicator(null)
      .setCateringCode(Collections.emptySet())
      .setServiceBranding(null)
      .setStpIndicator(StpIndicator.PERMANENT_ASSOCIATION)
      .setSpare(null)
      .createBasicSchedule();
    
    assertThat(actual).isEqualTo(expected);
  }
}