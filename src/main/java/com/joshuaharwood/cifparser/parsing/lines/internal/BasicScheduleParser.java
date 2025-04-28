package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.Converter.convert;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BankHolidayRunningField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule.BasicScheduleField;
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
import java.util.List;

public final class BasicScheduleParser implements RecordSpecificParser<BasicSchedule> {

  private final List<BasicScheduleField<?>> fieldDefinitions;

  public BasicScheduleParser(List<BasicScheduleField<?>> fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public BasicSchedule parse(String record) {
    final var builder = new BasicSchedule.Builder();

    for (BasicScheduleField<?> basicScheduleField : fieldDefinitions) {
      switch (basicScheduleField) {
        case RecordIdentityField _ -> {
        }
        case BankHolidayRunningField v -> builder.setBankHolidayRunning(convert(v, record));
        case BusinessSectorPortionIdField v -> builder.setPortionId(convert(v, record));
        case CateringCodeField v -> builder.setCateringCode(convert(v, record));
        case ConnectIndicatorField v -> builder.setConnectionIndicator(convert(v, record));
        case CourseIndicatorField v -> builder.setCourseIndicator(convert(v, record));
        case DateRunsFromField v -> builder.setDateRunsFrom(convert(v, record));
        case DateRunsToField v -> builder.setDateRunsTo(convert(v, record));
        case DaysRunField v -> builder.setDaysRun(convert(v, record));
        case HeadcodeField v -> builder.setHeadcode(convert(v, record));
        case OperatingCharacteristicsField v ->
          builder.setOperatingCharacteristics(convert(v, record));
        case PowerTypeField v -> builder.setPowerType(convert(v, record));
        case ProfitCentreCodeField v -> builder.setTrainServiceCode(convert(v, record));
        case ReservationsField v -> builder.setReservations(convert(v, record));
        case ServiceBrandingField v -> builder.setServiceBranding(convert(v, record));
        case SleepersField v -> builder.setSleepers(convert(v, record));
        case SpareField v -> builder.setSpare(convert(v, record));
        case SpeedField v -> builder.setSpeed(convert(v, record));
        case StpIndicatorField v -> builder.setStpIndicator(convert(v, record));
        case TimingLoadField v -> builder.setTimingLoad(convert(v, record));
        case TrainCategoryField v -> builder.setTrainCategory(convert(v, record));
        case TrainClassField v -> builder.setSeatingClass(convert(v, record));
        case TrainIdentityField v -> builder.setTrainIdentity(convert(v, record));
        case TrainStatusField v -> builder.setTrainStatus(convert(v, record));
        case TrainUidField v -> builder.setTrainUid(convert(v, record));
        case TransactionTypeField v -> builder.setTransactionType(convert(v, record));
      }
    }

    return builder.createBasicSchedule();
  }
}