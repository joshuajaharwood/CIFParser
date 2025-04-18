package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.ParsingHelpers.requiredLookup;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.BasicScheduleField;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleBuilder;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Map;
import org.jspecify.annotations.Nullable;

public final class BasicScheduleParser implements RecordSpecificParser<BasicSchedule> {

  @Override
  public BasicSchedule parse(String record) {
    final Map<BasicScheduleField, String> parsedValues = StringParser.parse(record,
      BasicScheduleField.values());

    var builder = new BasicScheduleBuilder();

    for (BasicScheduleField value : BasicScheduleField.values()) {
      var parsedValue = parsedValues.get(value);

      if (value.isRequired() && parsedValue == null) {
        throw new RequiredPropertyMissingException(value.getName(), parsedValues);
      }
      
      if (value.isRequired()) {
        if (value.getMarshallableType().isInstance()) {
          
        }
      }

      // We return the builder here to ensure exhaustiveness. Language quirk...
      BasicScheduleBuilder x = switch (value) {
//        case CATERING_CODE -> builder.setCateringCode();
        case SPARE -> builder.setSpare(parsedValue);
        case TRANSACTION_TYPE -> builder.setTransactionType(requiredLookup(parsedValues,
          BasicScheduleField.TRANSACTION_TYPE,
          TransactionType.class));
        case TRAIN_UID -> builder.setTrainUid(parsedValue);
        case DATE_RUNS_FROM -> false;
        case DATE_RUNS_TO -> false;
        case DAYS_RUN -> false;
        case BANK_HOLIDAY_RUNNING -> false;
        case TRAIN_STATUS -> false;
        case TRAIN_CATEGORY -> false;
        case TRAIN_IDENTITY -> false;
        case HEADCODE -> false;
        case COURSE_INDICATOR -> false;
        case PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE -> false;
        case BUSINESS_SECTOR_PORTION_ID -> false;
        case POWER_TYPE -> false;
        case TIMING_LOAD -> false;
        case SPEED -> false;
        case OPERATING_CHARACTERISTICS -> false;
        case TRAIN_CLASS -> false;
        case SLEEPERS -> false;
        case RESERVATIONS -> false;
        case CONNECT_INDICATOR -> false;
        case CATERING_CODE -> false;
        case SERVICE_BRANDING -> false;
        case STP_INDICATOR -> false;
        // No-op
        case RECORD_IDENTITY -> builder;
      };

    }

    return builder.createBasicSchedule();

//    return new BasicScheduleBuilder().setTransactionType(requiredLookup(parsedValues,
//        BasicScheduleField.TRANSACTION_TYPE,
//        TransactionType.class))
//      .setTrainUid(required(parsedValues, BasicScheduleField.TRAIN_UID))
//      .setDateRunsFrom(InverseDateConverter.apply(required(parsedValues,
//        BasicScheduleField.DATE_RUNS_FROM)))
//      .setDateRunsTo(optional(InverseDateConverter.apply(parsedValues.get(BasicScheduleField.DATE_RUNS_TO)),
//
//        DaysOfWeekBitmaskConverter.apply(required(parsedValues.get(BasicScheduleField.DAYS_RUN)),
//          lookup(BankHolidayRunning.class,
//            parsedValues.get(BasicScheduleField.BANK_HOLIDAY_RUNNING)).orElse(null),
//          lookup(TrainStatus.class, parsedValues.get(BasicScheduleField.TRAIN_STATUS)).orElse(null),
//          lookup(TrainCategory.class, parsedValues.get(BasicScheduleField.TRAIN_CATEGORY)).orElse(
//            null),
//          ifPresent(parsedValues.get(BasicScheduleField.TRAIN_IDENTITY)).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.HEADCODE)).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.COURSE_INDICATOR)).map(Byte::parseByte)
//            .orElseThrow(() -> new RequiredPropertyMissingException(BasicScheduleField.COURSE_INDICATOR.getName(),
//              parsedValues)),
//          ifPresent(parsedValues.get(BasicScheduleField.PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE)).map(
//            Integer::valueOf).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.BUSINESS_SECTOR_PORTION_ID)).map(this::parseChar)
//            .orElse(null),
//          lookup(PowerType.class, parsedValues.get(BasicScheduleField.POWER_TYPE)).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.TIMING_LOAD)).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.SPEED)).map(Integer::valueOf).orElse(null),
//          lookupSet(OperatingCharacteristics.class,
//            parsedValues.get(BasicScheduleField.OPERATING_CHARACTERISTICS)),
//          lookup(SeatingClass.class, parsedValues.get(BasicScheduleField.TRAIN_CLASS)).orElse(null),
//          lookup(Sleepers.class, parsedValues.get(BasicScheduleField.SLEEPERS)).orElse(null),
//          lookup(Reservations.class,
//            parsedValues.get(BasicScheduleField.RESERVATIONS)).orElse(null),
//          ifPresent(parsedValues.get(BasicScheduleField.CONNECT_INDICATOR)).map(this::parseChar)
//            .orElse(null),
//          lookupSet(CateringCode.class, parsedValues.get(BasicScheduleField.CATERING_CODE)),
//          ifPresent(parsedValues.get(BasicScheduleField.SERVICE_BRANDING)).orElse(null),
//          lookup(StpIndicator.class,
//            parsedValues.get(BasicScheduleField.STP_INDICATOR)).orElseThrow(() -> new RequiredPropertyMissingException(
//            BasicScheduleField.STP_INDICATOR.getName(),
//            parsedValues)),
//          ifPresent(parsedValues.get(BasicScheduleField.SPARE)).orElse(null))).createBasicSchedule();
  }

  private @Nullable String getValue(Map<BasicScheduleField, String> parsedValues,
    BasicScheduleField key,
    boolean required) {
    var value = parsedValues.get(key);

    if (value == null && required) {
      throw new RequiredPropertyMissingException(key.getName(), parsedValues);
    }

    return value;
  }
}
