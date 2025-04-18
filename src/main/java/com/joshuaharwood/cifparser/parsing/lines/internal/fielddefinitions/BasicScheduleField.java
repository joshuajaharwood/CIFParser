package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions;

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

public final class BasicScheduleField {
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

  public static final RowField<String> RECORD_IDENTITY = new BasicScheduleFieldImpl<>(
    "RECORD_IDENTITY",
    1,
    2,
    true,
    NOOP_CONVERTER);
  public static final RowField<TransactionType> TRANSACTION_TYPE = new BasicScheduleFieldImpl<>(
    "TRANSACTION_TYPE",
    2,
    1,
    true,
    TRANSACTION_TYPE_CONVERTER);
  public static final RowField<String> TRAIN_UID = new BasicScheduleFieldImpl<>("TRAIN_UID",
    3,
    6,
    true,
    NOOP_CONVERTER);
  public static final RowField<LocalDate> DATE_RUNS_FROM = new BasicScheduleFieldImpl<>(
    "DATE_RUNS_FROM",
    4,
    6,
    true,
    INVERSE_DATE_CONVERTER);
  public static final RowField<LocalDate> DATE_RUNS_TO = new BasicScheduleFieldImpl<>("DATE_RUNS_TO",
    5,
    6,
    false,
    INVERSE_DATE_CONVERTER);
  public static final RowField<Set<DayOfWeek>> DAYS_RUN = new BasicScheduleFieldImpl<>("DAYS_RUN",
    6,
    7,
    true,
    DAYS_OF_WEEK_BITMASK_CONVERTER);
  public static final RowField<BankHolidayRunning> BANK_HOLIDAY_RUNNING = new BasicScheduleFieldImpl<>(
    "BANK_HOLIDAY_RUNNING",
    7,
    1,
    false,
    BANK_HOLIDAY_RUNNING_CONVERTER);
  public static final RowField<TrainStatus> TRAIN_STATUS = new BasicScheduleFieldImpl<>(
    "TRAIN_STATUS",
    8,
    1,
    false,
    TRAIN_STATUS_CONVERTER);
  public static final RowField<TrainCategory> TRAIN_CATEGORY = new BasicScheduleFieldImpl<>(
    "TRAIN_CATEGORY",
    9,
    2,
    false,
    TRAIN_CATEGORY_CONVERTER);
  public static final RowField<String> TRAIN_IDENTITY = new BasicScheduleFieldImpl<>(
    "TRAIN_IDENTITY",
    10,
    4,
    false,
    NOOP_CONVERTER);
  public static final RowField<String> HEADCODE = new BasicScheduleFieldImpl<>("HEADCODE",
    11,
    4,
    false,
    NOOP_CONVERTER);
  public static final RowField<Byte> COURSE_INDICATOR = new BasicScheduleFieldImpl<>(
    "COURSE_INDICATOR",
    12,
    1,
    false,
    Byte::parseByte);
  public static final RowField<Integer> PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE = new BasicScheduleFieldImpl<>(
    "PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE",
    13,
    8,
    false,
    Integer::valueOf);
  public static final RowField<Character> BUSINESS_SECTOR_PORTION_ID = new BasicScheduleFieldImpl<>(
    "BUSINESS_SECTOR_PORTION_ID",
    14,
    1,
    false,
    ParsingHelpers::parseChar);
  public static final RowField<String> POWER_TYPE = new BasicScheduleFieldImpl<>("POWER_TYPE",
    15,
    3,
    false,
    POWER_TYPE_CONVERTER);
  public static final RowField<String> TIMING_LOAD = new BasicScheduleFieldImpl<>("TIMING_LOAD",
    16,
    4,
    false,
    NOOP_CONVERTER);
  public static final RowField<Integer> SPEED = new BasicScheduleFieldImpl<>("SPEED",
    17,
    3,
    false,
    Integer::valueOf);
  public static final RowField<Set<OperatingCharacteristics>> OPERATING_CHARACTERISTICS = new BasicScheduleFieldImpl<>(
    "OPERATING_CHARACTERISTICS",
    18,
    6,
    true,
    OPERATING_CHARACTERISTICS_CONVERTER);
  public static final RowField<SeatingClass> TRAIN_CLASS = new BasicScheduleFieldImpl<>("TRAIN_CLASS",
    19,
    1,
    false,
    TRAIN_CLASS_CONVERTER);
  public static final RowField<Sleepers> SLEEPERS = new BasicScheduleFieldImpl<>("SLEEPERS",
    20,
    1,
    false,
    SLEEPERS_CONVERTER);
  public static final RowField<Reservations> RESERVATIONS = new BasicScheduleFieldImpl<>("RESERVATIONS",
    21,
    1,
    false,
    RESERVATIONS_CONVERTER);
  public static final RowField<String> CONNECT_INDICATOR = new BasicScheduleFieldImpl<>(
    "CONNECT_INDICATOR",
    22,
    1,
    true,
    NOOP_CONVERTER);
  public static final RowField<Set<CateringCode>> CATERING_CODE = new BasicScheduleFieldImpl<>("CATERING_CODE",
    23,
    4,
    true,
    CATERING_CODE_CONVERTER);
  public static final RowField<String> SERVICE_BRANDING = new BasicScheduleFieldImpl<>(
    "SERVICE_BRANDING",
    24,
    4,
    true,
    NOOP_CONVERTER);
  public static final RowField<String> SPARE = new BasicScheduleFieldImpl<>("SPARE",
    25,
    1,
    false,
    NOOP_CONVERTER);
  public static final RowField<String> STP_INDICATOR = new BasicScheduleFieldImpl<>("STP_INDICATOR",
    26,
    1,
    true,
    STP_INDICATOR_CONVERTER);

  private record BasicScheduleFieldImpl<T>(String name, int order, int length, boolean isRequired,
                                           Converter<T> getConverter) implements RowField<T> {
    
    
  }
  
  
}