package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.ParsingHelpers;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralSetConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.NoopConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.BankHolidayRunning;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;


public record BasicScheduleField<T>(String name, int order, int length, boolean isRequired,
                                         Converter<T> getConverter) implements RowField<T> {

  private static final NoopConverter NOOP_CONVERTER = NoopConverter.getInstance();
  private static final InverseDateConverter INVERSE_DATE_CONVERTER = InverseDateConverter.getInstance();
  private static final DaysOfWeekBitmaskConverter DAYS_OF_WEEK_BITMASK_CONVERTER = DaysOfWeekBitmaskConverter.getInstance();
  private static final LiteralConverter<TransactionType> TRANSACTION_TYPE_CONVERTER = LiteralConverter.getInstance(TransactionType.class);
  private static final LiteralConverter<BankHolidayRunning> BANK_HOLIDAY_RUNNING_CONVERTER = LiteralConverter.getInstance(BankHolidayRunning.class);
  private static final LiteralConverter<TrainStatus> TRAIN_STATUS_CONVERTER = LiteralConverter.getInstance(TrainStatus.class);
  private static final LiteralConverter<TrainCategory> TRAIN_CATEGORY_CONVERTER = LiteralConverter.getInstance(TrainCategory.class);
  private static final LiteralConverter<PowerType> POWER_TYPE_CONVERTER = LiteralConverter.getInstance(PowerType.class);
  private static final LiteralSetConverter<OperatingCharacteristics> OPERATING_CHARACTERISTICS_CONVERTER = LiteralSetConverter.getInstance(OperatingCharacteristics.class);
  private static final LiteralConverter<Sleepers> SLEEPERS_CONVERTER = LiteralConverter.getInstance(Sleepers.class);
  private static final LiteralConverter<SeatingClass> TRAIN_CLASS_CONVERTER = LiteralConverter.getInstance(SeatingClass.class);
  private static final LiteralConverter<Reservations> RESERVATIONS_CONVERTER = LiteralConverter.getInstance(Reservations.class);
  private static final LiteralSetConverter<CateringCode> CATERING_CODE_CONVERTER = LiteralSetConverter.getInstance(CateringCode.class);
  private static final LiteralConverter<StpIndicator> STP_INDICATOR_CONVERTER = LiteralConverter.getInstance(StpIndicator.class);

  public static final BasicScheduleField<String> RECORD_IDENTITY = new BasicScheduleField<>(
    "RECORD_IDENTITY",
    1,
    2,
    true,
    NOOP_CONVERTER);
  public static final BasicScheduleField<TransactionType> TRANSACTION_TYPE = new BasicScheduleField<>(
    "TRANSACTION_TYPE",
    2,
    1,
    true,
    TRANSACTION_TYPE_CONVERTER);
  public static final BasicScheduleField<String> TRAIN_UID = new BasicScheduleField<>("TRAIN_UID",
    3,
    6,
    true,
    NOOP_CONVERTER);
  public static final BasicScheduleField<LocalDate> DATE_RUNS_FROM = new BasicScheduleField<>(
    "DATE_RUNS_FROM",
    4,
    6,
    true,
    INVERSE_DATE_CONVERTER);
  public static final BasicScheduleField<LocalDate> DATE_RUNS_TO = new BasicScheduleField<>("DATE_RUNS_TO",
    5,
    6,
    false,
    INVERSE_DATE_CONVERTER);
  public static final BasicScheduleField<Set<DayOfWeek>> DAYS_RUN = new BasicScheduleField<>("DAYS_RUN",
    6,
    7,
    true,
    DAYS_OF_WEEK_BITMASK_CONVERTER);
  public static final BasicScheduleField<BankHolidayRunning> BANK_HOLIDAY_RUNNING = new BasicScheduleField<>(
    "BANK_HOLIDAY_RUNNING",
    7,
    1,
    false,
    BANK_HOLIDAY_RUNNING_CONVERTER);
  public static final BasicScheduleField<TrainStatus> TRAIN_STATUS = new BasicScheduleField<>(
    "TRAIN_STATUS",
    8,
    1,
    false,
    TRAIN_STATUS_CONVERTER);
  public static final BasicScheduleField<TrainCategory> TRAIN_CATEGORY = new BasicScheduleField<>(
    "TRAIN_CATEGORY",
    9,
    2,
    false,
    TRAIN_CATEGORY_CONVERTER);
  public static final BasicScheduleField<String> TRAIN_IDENTITY = new BasicScheduleField<>(
    "TRAIN_IDENTITY",
    10,
    4,
    false,
    NOOP_CONVERTER);
  public static final BasicScheduleField<String> HEADCODE = new BasicScheduleField<>("HEADCODE",
    11,
    4,
    false,
    NOOP_CONVERTER);
  public static final BasicScheduleField<Byte> COURSE_INDICATOR = new BasicScheduleField<>(
    "COURSE_INDICATOR",
    12,
    1,
    false,
    Byte::parseByte);
  public static final BasicScheduleField<Integer> PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE = new BasicScheduleField<>(
    "PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE",
    13,
    8,
    false,
    Integer::valueOf);
  public static final BasicScheduleField<Character> BUSINESS_SECTOR_PORTION_ID = new BasicScheduleField<>(
    "BUSINESS_SECTOR_PORTION_ID",
    14,
    1,
    false,
    ParsingHelpers::parseChar);
  public static final BasicScheduleField<PowerType> POWER_TYPE = new BasicScheduleField<>("POWER_TYPE",
    15,
    3,
    false,
    POWER_TYPE_CONVERTER);
  public static final BasicScheduleField<String> TIMING_LOAD = new BasicScheduleField<>("TIMING_LOAD",
    16,
    4,
    false,
    NOOP_CONVERTER);
  public static final BasicScheduleField<Integer> SPEED = new BasicScheduleField<>("SPEED",
    17,
    3,
    false,
    Integer::valueOf);
  public static final BasicScheduleField<Set<OperatingCharacteristics>> OPERATING_CHARACTERISTICS = new BasicScheduleField<>(
    "OPERATING_CHARACTERISTICS",
    18,
    6,
    true,
    OPERATING_CHARACTERISTICS_CONVERTER);
  public static final BasicScheduleField<SeatingClass> TRAIN_CLASS = new BasicScheduleField<>("TRAIN_CLASS",
    19,
    1,
    false,
    TRAIN_CLASS_CONVERTER);
  public static final BasicScheduleField<Sleepers> SLEEPERS = new BasicScheduleField<>("SLEEPERS",
    20,
    1,
    false,
    SLEEPERS_CONVERTER);
  public static final BasicScheduleField<Reservations> RESERVATIONS = new BasicScheduleField<>("RESERVATIONS",
    21,
    1,
    false,
    RESERVATIONS_CONVERTER);
  public static final BasicScheduleField<String> CONNECT_INDICATOR = new BasicScheduleField<>(
    "CONNECT_INDICATOR",
    22,
    1,
    true,
    NOOP_CONVERTER);
  public static final BasicScheduleField<Set<CateringCode>> CATERING_CODE = new BasicScheduleField<>("CATERING_CODE",
    23,
    4,
    true,
    CATERING_CODE_CONVERTER);
  public static final BasicScheduleField<String> SERVICE_BRANDING = new BasicScheduleField<>(
    "SERVICE_BRANDING",
    24,
    4,
    true,
    NOOP_CONVERTER);
  public static final BasicScheduleField<String> SPARE = new BasicScheduleField<>("SPARE",
    25,
    1,
    false,
    NOOP_CONVERTER);
  public static final BasicScheduleField<StpIndicator> STP_INDICATOR = new BasicScheduleField<>("STP_INDICATOR",
    26,
    1,
    true,
    STP_INDICATOR_CONVERTER);
  
  // todo: can we make this programmatic?
  public static ImmutableList<BasicScheduleField<?>> getFields() {
    return ImmutableList.of(RECORD_IDENTITY,
      TRANSACTION_TYPE,
      TRAIN_UID,
      DATE_RUNS_FROM,
      DATE_RUNS_TO,
      DAYS_RUN,
      BANK_HOLIDAY_RUNNING,
      TRAIN_STATUS,
      TRAIN_CATEGORY,
      TRAIN_IDENTITY,
      HEADCODE,
      COURSE_INDICATOR,
      PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE,
      BUSINESS_SECTOR_PORTION_ID,
      POWER_TYPE,
      TIMING_LOAD,
      SPEED,
      OPERATING_CHARACTERISTICS,
      TRAIN_CLASS,
      SLEEPERS,
      RESERVATIONS,
      CONNECT_INDICATOR,
      CATERING_CODE,
      SERVICE_BRANDING,
      SPARE,
      STP_INDICATOR);
  }
}