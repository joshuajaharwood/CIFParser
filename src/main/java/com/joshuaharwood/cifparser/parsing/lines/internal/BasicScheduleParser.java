package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BasicScheduleField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.BankHolidayRunning;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public final class BasicScheduleParser implements RecordSpecificParser<BasicSchedule> {

  private final BasicScheduleRowDefinition fieldDefinitions;

  public BasicScheduleParser() {
    this(BasicScheduleRowDefinition.DEFAULT);
  }

  public BasicScheduleParser(BasicScheduleRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public BasicSchedule parse(String record) {
    return new BasicSchedule(fieldDefinitions.transactionType().substringAndConvert(record),
      fieldDefinitions.trainUid().substringAndConvert(record),
      fieldDefinitions.dateRunsFrom().substringAndConvert(record),
      fieldDefinitions.dateRunsTo().substringAndConvert(record),
      fieldDefinitions.daysRun().substringAndConvert(record),
      fieldDefinitions.bankHolidayRunning().substringAndConvert(record),
      fieldDefinitions.trainStatus().substringAndConvert(record),
      fieldDefinitions.trainCategory().substringAndConvert(record),
      fieldDefinitions.trainIdentity().substringAndConvert(record),
      fieldDefinitions.headCode().substringAndConvert(record),
      fieldDefinitions.courseIndicator().substringAndConvert(record),
      fieldDefinitions.profitCentreCode().substringAndConvert(record),
      fieldDefinitions.businessSector().substringAndConvert(record),
      fieldDefinitions.powerType().substringAndConvert(record),
      fieldDefinitions.timingLoad().substringAndConvert(record),
      fieldDefinitions.speed().substringAndConvert(record),
      fieldDefinitions.operatingCharacteristics().substringAndConvert(record),
      fieldDefinitions.trainClass().substringAndConvert(record),
      fieldDefinitions.sleepers().substringAndConvert(record),
      fieldDefinitions.reservations().substringAndConvert(record),
      fieldDefinitions.connectIndicator().substringAndConvert(record),
      fieldDefinitions.cateringCode().substringAndConvert(record),
      fieldDefinitions.serviceBranding().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record),
      fieldDefinitions.stpIndicator().substringAndConvert(record));
  }

  public record BasicScheduleRowDefinition(RowField<RecordIdentity> recordIdentity,
                                           RowField<TransactionType> transactionType,
                                           RowField<String> trainUid,
                                           RowField<LocalDate> dateRunsFrom,
                                           RowField<LocalDate> dateRunsTo,
                                           RowField<Set<DayOfWeek>> daysRun,
                                           RowField<BankHolidayRunning> bankHolidayRunning,
                                           RowField<TrainStatus> trainStatus,
                                           RowField<TrainCategory> trainCategory,
                                           RowField<String> trainIdentity,
                                           RowField<String> headCode,
                                           RowField<Byte> courseIndicator,
                                           RowField<Integer> profitCentreCode,
                                           RowField<Character> businessSector,
                                           RowField<PowerType> powerType,
                                           RowField<String> timingLoad, RowField<Integer> speed,
                                           RowField<Set<OperatingCharacteristics>> operatingCharacteristics,
                                           RowField<SeatingClass> trainClass,
                                           RowField<Sleepers> sleepers,
                                           RowField<Reservations> reservations,
                                           RowField<Character> connectIndicator,
                                           RowField<Set<CateringCode>> cateringCode,
                                           RowField<String> serviceBranding, RowField<String> spare,
                                           RowField<StpIndicator> stpIndicator

  ) {

    public static final BasicScheduleRowDefinition DEFAULT = new BasicScheduleRowDefinition(
      Instances.RECORD_IDENTITY_FIELD,
      Instances.TRANSACTION_TYPE_FIELD,
      Instances.TRAIN_UID_FIELD,
      Instances.DATE_RUNS_FROM_FIELD,
      Instances.DATE_RUNS_TO_FIELD,
      Instances.DAYS_RUN_FIELD,
      Instances.BANK_HOLIDAY_RUNNING_FIELD,
      Instances.TRAIN_STATUS_FIELD,
      Instances.TRAIN_CATEGORY_FIELD,
      Instances.TRAIN_IDENTITY_FIELD,
      Instances.HEADCODE_FIELD,
      Instances.COURSE_INDICATOR_FIELD,
      Instances.PROFIT_CENTRE_CODE_FIELD,
      Instances.BUSINESS_SECTOR_PORTION_ID_FIELD,
      Instances.POWER_TYPE_FIELD,
      Instances.TIMING_LOAD_FIELD,
      Instances.SPEED_FIELD,
      Instances.OPERATING_CHARACTERISTICS_FIELD,
      Instances.TRAIN_CLASS_FIELD,
      Instances.SLEEPERS_FIELD,
      Instances.RESERVATIONS_FIELD,
      Instances.CONNECT_INDICATOR_FIELD,
      Instances.CATERING_CODE_FIELD,
      Instances.SERVICE_BRANDING_FIELD,
      Instances.SPARE_FIELD,
      Instances.STP_INDICATOR_FIELD);
  }
}