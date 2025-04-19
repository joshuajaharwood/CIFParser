package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface BasicScheduleField<T> extends RowField<T> permits
  RecordIdentityField, TransactionTypeField,
  TrainUidField, DateRunsFromField,
  DateRunsToField, DaysRunField,
  BankHolidayRunningField, TrainStatusField,
  TrainCategoryField, TrainIdentityField,
  HeadcodeField, CourseIndicatorField,
  ProfitCentreCodeField, BusinessSectorPortionIdField,
  PowerTypeField, TimingLoadField,
  SpeedField, OperatingCharacteristicsField,
  TrainClassField, SleepersField,
  ReservationsField, ConnectIndicatorField,
  CateringCodeField, ServiceBrandingField,
  SpareField, StpIndicatorField {
}