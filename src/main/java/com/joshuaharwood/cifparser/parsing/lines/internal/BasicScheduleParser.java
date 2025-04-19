package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BankHolidayRunningField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BasicScheduleField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BasicScheduleFieldInstances;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BusinessSectorPortionIdField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.CateringCodeField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.ConnectIndicatorField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.CourseIndicatorField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.DateRunsFromField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.DateRunsToField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.DaysRunField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.HeadcodeField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.OperatingCharacteristicsField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.PowerTypeField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.ProfitCentreCodeField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.RecordIdentityField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.ReservationsField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.ServiceBrandingField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.SleepersField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.SpareField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.SpeedField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.StpIndicatorField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TimingLoadField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TrainCategoryField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TrainClassField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TrainIdentityField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TrainStatusField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TrainUidField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.TransactionTypeField;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleBuilder;
import java.util.Map;

public final class BasicScheduleParser implements RecordSpecificParser<BasicSchedule> {

  @Override
  public BasicSchedule parse(String record) {
    final Map<BasicScheduleField<?>, String> parsedValues = StringParser.parse(record,
      BasicScheduleFieldInstances.getAll());

    var builder = new BasicScheduleBuilder();

    for (var fieldEntry : parsedValues.entrySet()) {
      switch (fieldEntry.getKey()) {
        case BankHolidayRunningField bankHolidayRunningField -> {
        }
        case BusinessSectorPortionIdField businessSectorPortionIdField -> {
        }
        case CateringCodeField cateringCodeField -> {
        }
        case ConnectIndicatorField connectIndicatorField -> {
        }
        case CourseIndicatorField courseIndicatorField -> {
        }
        case DateRunsFromField dateRunsFromField -> {
        }
        case DateRunsToField dateRunsToField -> {
        }
        case DaysRunField daysRunField -> {
        }
        case HeadcodeField headcodeField -> {
        }
        case OperatingCharacteristicsField operatingCharacteristicsField -> {
        }
        case PowerTypeField powerTypeField -> {
        }
        case ProfitCentreCodeField profitCentreCodeField -> {
        }
        case RecordIdentityField recordIdentityField -> {
        }
        case ReservationsField reservationsField -> {
        }
        case ServiceBrandingField serviceBrandingField -> {
        }
        case SleepersField sleepersField -> {
        }
        case SpareField spareField -> {
        }
        case SpeedField speedField -> {
        }
        case StpIndicatorField stpIndicatorField -> {
        }
        case TimingLoadField timingLoadField -> {
        }
        case TrainCategoryField trainCategoryField -> {
        }
        case TrainClassField trainClassField -> {
        }
        case TrainIdentityField trainIdentityField -> {
        }
        case TrainStatusField trainStatusField -> {
        }
        case TrainUidField trainUidField -> {
        }
        case TransactionTypeField transactionTypeField -> {
        }
      }


    }

    return builder.createBasicSchedule();

  }
