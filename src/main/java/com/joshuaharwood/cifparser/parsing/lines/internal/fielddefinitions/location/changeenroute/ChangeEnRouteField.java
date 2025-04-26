package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface ChangeEnRouteField<T> extends RowField<T> permits
  RecordIdentityField, LocationField, TrainCategoryField, TrainIdentityField,
  HeadcodeField, CourseIndicatorField, ProfitCentreCodeTrainServiceCodeField,
  BusinessSectorField, PowerTypeField, TimingLoadField, SpeedField,
  OperatingCharacteristicsField, TrainClassField, SleepersField,
  ReservationsField, ConnectIndicatorField, CateringCodeField,
  ServiceBrandingField, TractionClassField, UicCodeField,
  RetailServiceIdField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final LocationField LOCATION = new LocationField();
    public static final TrainCategoryField TRAIN_CATEGORY = new TrainCategoryField();
    public static final TrainIdentityField TRAIN_IDENTITY = new TrainIdentityField();
    public static final HeadcodeField HEADCODE = new HeadcodeField();
    public static final CourseIndicatorField COURSE_INDICATOR = new CourseIndicatorField();
    public static final ProfitCentreCodeTrainServiceCodeField PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE = new ProfitCentreCodeTrainServiceCodeField();
    public static final BusinessSectorField BUSINESS_SECTOR = new BusinessSectorField();
    public static final PowerTypeField POWER_TYPE = new PowerTypeField();
    public static final TimingLoadField TIMING_LOAD = new TimingLoadField();
    public static final SpeedField SPEED = new SpeedField();
    public static final OperatingCharacteristicsField OPERATING_CHARACTERISTICS = new OperatingCharacteristicsField();
    public static final TrainClassField TRAIN_CLASS = new TrainClassField();
    public static final SleepersField SLEEPERS = new SleepersField();
    public static final ReservationsField RESERVATIONS = new ReservationsField();
    public static final ConnectIndicatorField CONNECT_INDICATOR = new ConnectIndicatorField();
    public static final CateringCodeField CATERING_CODE = new CateringCodeField();
    public static final ServiceBrandingField SERVICE_BRANDING = new ServiceBrandingField();
    public static final TractionClassField TRACTION_CLASS = new TractionClassField();
    public static final UicCodeField UIC_CODE = new UicCodeField();
    public static final RetailServiceIdField RETAIL_SERVICE_ID = new RetailServiceIdField();
    public static final SpareField SPARE = new SpareField();

    private static final ImmutableList<ChangeEnRouteField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      LOCATION,
      TRAIN_CATEGORY,
      TRAIN_IDENTITY,
      HEADCODE,
      COURSE_INDICATOR,
      PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE,
      BUSINESS_SECTOR,
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
      TRACTION_CLASS,
      UIC_CODE,
      RETAIL_SERVICE_ID,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<ChangeEnRouteField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}
