package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface BasicScheduleField<T> extends RowField<T> permits BankHolidayRunningField,
  BusinessSectorPortionIdField, CateringCodeField, ConnectIndicatorField, CourseIndicatorField,
  DateRunsFromField, DateRunsToField, DaysRunField, HeadcodeField, OperatingCharacteristicsField,
  PowerTypeField, ProfitCentreCodeField, RecordIdentityField, ReservationsField,
  ServiceBrandingField, SleepersField, SpareField, SpeedField, StpIndicatorField, TimingLoadField,
  TrainCategoryField, TrainClassField, TrainIdentityField, TrainStatusField, TrainUidField,
  TransactionTypeField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY_FIELD = new RecordIdentityField();
    public static final TransactionTypeField TRANSACTION_TYPE_FIELD = new TransactionTypeField();
    public static final TrainUidField TRAIN_UID_FIELD = new TrainUidField();
    public static final DateRunsFromField DATE_RUNS_FROM_FIELD = new DateRunsFromField();
    public static final DateRunsToField DATE_RUNS_TO_FIELD = new DateRunsToField();
    public static final DaysRunField DAYS_RUN_FIELD = new DaysRunField();
    public static final BankHolidayRunningField BANK_HOLIDAY_RUNNING_FIELD = new BankHolidayRunningField();
    public static final TrainStatusField TRAIN_STATUS_FIELD = new TrainStatusField();
    public static final TrainCategoryField TRAIN_CATEGORY_FIELD = new TrainCategoryField();
    public static final TrainIdentityField TRAIN_IDENTITY_FIELD = new TrainIdentityField();
    public static final HeadcodeField HEADCODE_FIELD = new HeadcodeField();
    public static final CourseIndicatorField COURSE_INDICATOR_FIELD = new CourseIndicatorField();
    public static final ProfitCentreCodeField PROFIT_CENTRE_CODE_FIELD = new ProfitCentreCodeField();
    public static final BusinessSectorPortionIdField BUSINESS_SECTOR_PORTION_ID_FIELD = new BusinessSectorPortionIdField();
    public static final PowerTypeField POWER_TYPE_FIELD = new PowerTypeField();
    public static final TimingLoadField TIMING_LOAD_FIELD = new TimingLoadField();
    public static final SpeedField SPEED_FIELD = new SpeedField();
    public static final OperatingCharacteristicsField OPERATING_CHARACTERISTICS_FIELD = new OperatingCharacteristicsField();
    public static final TrainClassField TRAIN_CLASS_FIELD = new TrainClassField();
    public static final SleepersField SLEEPERS_FIELD = new SleepersField();
    public static final ReservationsField RESERVATIONS_FIELD = new ReservationsField();
    public static final ConnectIndicatorField CONNECT_INDICATOR_FIELD = new ConnectIndicatorField();
    public static final CateringCodeField CATERING_CODE_FIELD = new CateringCodeField();
    public static final ServiceBrandingField SERVICE_BRANDING_FIELD = new ServiceBrandingField();
    public static final SpareField SPARE_FIELD = new SpareField();
    public static final StpIndicatorField STP_INDICATOR_FIELD = new StpIndicatorField();

    private Instances() {
    }
  }
}