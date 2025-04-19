package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

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
import java.util.function.Function;

public class Converters {

  public static final Function<String, String> NOOP_CONVERTER = Function.identity();
  public static final InverseDateConverter INVERSE_DATE_CONVERTER = InverseDateConverter.getInstance();
  public static final DaysOfWeekBitmaskConverter DAYS_OF_WEEK_BITMASK_CONVERTER = DaysOfWeekBitmaskConverter.getInstance();
  public static final LiteralConverter<TransactionType> TRANSACTION_TYPE_CONVERTER = LiteralConverter.getInstance(
    TransactionType.class);
  public static final LiteralConverter<BankHolidayRunning> BANK_HOLIDAY_RUNNING_CONVERTER = LiteralConverter.getInstance(
    BankHolidayRunning.class);
  public static final LiteralConverter<TrainStatus> TRAIN_STATUS_CONVERTER = LiteralConverter.getInstance(
    TrainStatus.class);
  public static final LiteralConverter<TrainCategory> TRAIN_CATEGORY_CONVERTER = LiteralConverter.getInstance(
    TrainCategory.class);
  public static final LiteralConverter<PowerType> POWER_TYPE_CONVERTER = LiteralConverter.getInstance(
    PowerType.class);
  public static final LiteralSetConverter<OperatingCharacteristics> OPERATING_CHARACTERISTICS_CONVERTER = LiteralSetConverter.getInstance(
    OperatingCharacteristics.class);
  public static final LiteralConverter<Sleepers> SLEEPERS_CONVERTER = LiteralConverter.getInstance(
    Sleepers.class);
  public static final LiteralConverter<SeatingClass> TRAIN_CLASS_CONVERTER = LiteralConverter.getInstance(
    SeatingClass.class);
  public static final LiteralConverter<Reservations> RESERVATIONS_CONVERTER = LiteralConverter.getInstance(
    Reservations.class);
  public static final LiteralSetConverter<CateringCode> CATERING_CODE_CONVERTER = LiteralSetConverter.getInstance(
    CateringCode.class);
  public static final LiteralConverter<StpIndicator> STP_INDICATOR_CONVERTER = LiteralConverter.getInstance(
    StpIndicator.class);

  private Converters() {
  }
}
