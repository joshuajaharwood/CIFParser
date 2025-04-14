package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;
import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookupSet;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.BasicScheduleFields;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
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
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Map;

public final class BasicScheduleParser implements RecordSpecificParser<BasicSchedule> {

  @Override
  public BasicSchedule parse(String record) {
    final Map<BasicScheduleFields, String> parsedValues = StringParser.parse(record,
      BasicScheduleFields.values());

    return new BasicSchedule(
      requiredLookup(
        record,
        parsedValues,
        BasicScheduleFields.TRANSACTION_TYPE.getName(),
        TransactionType.class),
      required(
        record,
        parsedValues,
        BasicScheduleFields.TRAIN_UID.getName()),
      
      InverseDateConverter.convert(required(record, parsedValues, BasicScheduleFields.DATE_RUNS_FROM.getName())),
      InverseDateConverter.convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_TO),

      
//      InverseDateConverter.convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_FROM))
//        .orElseThrow(() -> new RequiredPropertyMissingException(BasicScheduleFields.DATE_RUNS_FROM.getName(),
//          record,
//          parsedValues)),
//      InverseDateConverter.convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_TO)).orElse(null),
//      DaysOfWeekBitmaskConverter.convert(parsedValues.get(BasicScheduleFields.DAYS_RUN)),
      lookup(BankHolidayRunning.class,
        parsedValues.get(BasicScheduleFields.BANK_HOLIDAY_RUNNING)).orElse(null),
      lookup(TrainStatus.class, parsedValues.get(BasicScheduleFields.TRAIN_STATUS)).orElse(null),
      lookup(TrainCategory.class,
        parsedValues.get(BasicScheduleFields.TRAIN_CATEGORY)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.TRAIN_IDENTITY)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.HEADCODE)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.COURSE_INDICATOR)).map(Byte::parseByte)
        .orElseThrow(() -> new RequiredPropertyMissingException(BasicScheduleFields.COURSE_INDICATOR.getName(),
          record,
          parsedValues)),
      ifPresent(parsedValues.get(BasicScheduleFields.PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE)).map(
        Integer::valueOf).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.BUSINESS_SECTOR_PORTION_ID)).map(this::parseChar)
        .orElse(null),
      lookup(PowerType.class, parsedValues.get(BasicScheduleFields.POWER_TYPE)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.TIMING_LOAD)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.SPEED)).map(Integer::valueOf).orElse(null),
      lookupSet(OperatingCharacteristics.class,
        parsedValues.get(BasicScheduleFields.OPERATING_CHARACTERISTICS)),
      lookup(SeatingClass.class, parsedValues.get(BasicScheduleFields.TRAIN_CLASS)).orElse(null),
      lookup(Sleepers.class, parsedValues.get(BasicScheduleFields.SLEEPERS)).orElse(null),
      lookup(Reservations.class, parsedValues.get(BasicScheduleFields.RESERVATIONS)).orElse(null),
      ifPresent(parsedValues.get(BasicScheduleFields.CONNECT_INDICATOR)).map(this::parseChar)
        .orElse(null),
      lookupSet(CateringCode.class, parsedValues.get(BasicScheduleFields.CATERING_CODE)),
      ifPresent(parsedValues.get(BasicScheduleFields.SERVICE_BRANDING)).orElse(null),
      lookup(StpIndicator.class,
        parsedValues.get(BasicScheduleFields.STP_INDICATOR)).orElseThrow(() -> new RequiredPropertyMissingException(
        BasicScheduleFields.STP_INDICATOR.getName(),
        record,
        parsedValues)),
      ifPresent(parsedValues.get(BasicScheduleFields.SPARE)).orElse(null));
  }
}
