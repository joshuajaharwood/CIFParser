package com.joshuaharwood.cifparser.parsing.parser;

import static com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup.lookup;
import static com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup.lookupCollection;

import com.joshuaharwood.cifparser.parsing.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.model.BasicSchedule.BankHolidayRunning;
import com.joshuaharwood.cifparser.parsing.model.BasicSchedule.TrainStatus;
import com.joshuaharwood.cifparser.parsing.model.converters.DaysOfWeekBitmaskConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.InverseDateConverter;
import com.joshuaharwood.cifparser.parsing.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.model.enums.ServiceBranding;
import com.joshuaharwood.cifparser.parsing.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.model.enums.TransactionType;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.BasicScheduleFields;
import java.util.Map;

public final class BasicScheduleParser implements RecordParser<BasicSchedule> {

  @Override
  public BasicSchedule parse(String record) {
    final Map<BasicScheduleFields, String> parsedValues = StringParser.parse(record,
        BasicScheduleFields.values());

    return new BasicSchedule(lookup(TransactionType.class,
        parsedValues.get(BasicScheduleFields.TRANSACTION_TYPE)).orElseThrow(() -> new RequiredPropertyMissingException(
        BasicScheduleFields.TRANSACTION_TYPE.getName(),
        record,
        parsedValues)),
        ifPresent(parsedValues.get(BasicScheduleFields.TRAIN_UID)).orElseThrow(() -> new RequiredPropertyMissingException(
            BasicScheduleFields.TRAIN_UID.getName(),
            record,
            parsedValues)),
        InverseDateConverter
            .convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_FROM))
            .orElseThrow(() -> new RequiredPropertyMissingException(BasicScheduleFields.DATE_RUNS_FROM.getName(),
                record,
                parsedValues)),
        InverseDateConverter
            .convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_TO))
            .orElse(null),
        DaysOfWeekBitmaskConverter
            .convert(parsedValues.get(BasicScheduleFields.DAYS_RUN))
            .orElse(null),
        lookup(BankHolidayRunning.class,
            parsedValues.get(BasicScheduleFields.BANK_HOLIDAY_RUNNING)).orElse(null),
        lookup(TrainStatus.class, parsedValues.get(BasicScheduleFields.TRAIN_STATUS)).orElse(null),
        lookup(TrainCategory.class, parsedValues.get(BasicScheduleFields.TRAIN_CATEGORY)).orElse(
            null),
        ifPresent(parsedValues.get(BasicScheduleFields.TRAIN_IDENTITY)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.HEADCODE))
            .map(Short::parseShort)
            .orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.COURSE_INDICATOR))
            .map(Byte::parseByte)
            .orElseThrow(() -> new RequiredPropertyMissingException(BasicScheduleFields.COURSE_INDICATOR.getName(),
                record,
                parsedValues)),
        ifPresent(parsedValues.get(BasicScheduleFields.PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE))
            .map(Integer::valueOf)
            .orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.BUSINESS_SECTOR_PORTION_ID))
            .map(this::parseChar)
            .orElse(null),
        lookup(PowerType.class, parsedValues.get(BasicScheduleFields.POWER_TYPE)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.TIMING_LOAD)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.SPEED)).map(Integer::valueOf).orElse(null),
        lookupCollection(OperatingCharacteristics.class,
            parsedValues.get(BasicScheduleFields.OPERATING_CHARACTERISTICS)),
        lookup(SeatingClass.class, parsedValues.get(BasicScheduleFields.TRAIN_CLASS)).orElse(null),
        lookup(Sleepers.class, parsedValues.get(BasicScheduleFields.SLEEPERS)).orElse(null),
        lookup(Reservations.class, parsedValues.get(BasicScheduleFields.RESERVATIONS)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleFields.CONNECT_INDICATOR))
            .map(this::parseChar)
            .orElse(null),
        lookupCollection(CateringCode.class, parsedValues.get(BasicScheduleFields.CATERING_CODE)),
        lookup(ServiceBranding.class,
            parsedValues.get(BasicScheduleFields.SERVICE_BRANDING)).orElse(null),
        lookup(StpIndicator.class, parsedValues.get(BasicScheduleFields.STP_INDICATOR)).orElseThrow(
            () -> new RequiredPropertyMissingException(BasicScheduleFields.STP_INDICATOR.getName(),
                record,
                parsedValues)),
        ifPresent(parsedValues.get(BasicScheduleFields.SPARE)).orElse(null));
  }
}
