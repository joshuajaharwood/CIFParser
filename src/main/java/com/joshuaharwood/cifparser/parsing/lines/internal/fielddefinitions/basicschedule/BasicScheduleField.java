package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface BasicScheduleField<T> extends RowField<T> permits BankHolidayRunningField,
  BusinessSectorPortionIdField, CateringCodeField, ConnectIndicatorField, CourseIndicatorField,
  DateRunsFromField, DateRunsToField, DaysRunField, HeadcodeField, OperatingCharacteristicsField,
  PowerTypeField, ProfitCentreCodeField, RecordIdentityField, ReservationsField,
  ServiceBrandingField, SleepersField, SpareField, SpeedField, StpIndicatorField, TimingLoadField,
  TrainCategoryField, TrainClassField, TrainIdentityField, TrainStatusField, TrainUidField,
  TransactionTypeField {
}