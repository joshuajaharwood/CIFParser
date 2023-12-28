//package com.joshuaharwood.cifparser.parsing.parser;
//
//import com.joshuaharwood.cifparser.parsing.model.BasicSchedule;
//import com.joshuaharwood.cifparser.parsing.model.BasicSchedule.BankHolidayRunning;
//import com.joshuaharwood.cifparser.parsing.model.CIFRecord;
//import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
//import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
//import com.joshuaharwood.cifparser.parsing.model.converters.DateConverter;
//import com.joshuaharwood.cifparser.parsing.model.converters.DaysOfWeekBitmaskConverter;
//import com.joshuaharwood.cifparser.parsing.model.converters.InverseDateConverter;
//import com.joshuaharwood.cifparser.parsing.model.converters.StringToCharacterConverter;
//import com.joshuaharwood.cifparser.parsing.model.converters.TimeConverter;
//import com.joshuaharwood.cifparser.parsing.model.enums.TransactionType;
//import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.BasicScheduleFields;
//import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
//import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
//import java.time.DayOfWeek;
//import java.util.Map;
//
//public final class BasicScheduleParser implements RecordParser<BasicSchedule> {
//
//  @Override
//  public BasicSchedule parse(String record) {
//    final Map<BasicScheduleFields, String> parsedValues = StringParser.parse(record,
//        BasicScheduleFields.values());
//
//    return new BasicSchedule(LiteralLookup.lookup(TransactionType.class,
//        parsedValues.get(BasicScheduleFields.TRANSACTION_TYPE)).orElse(null),
//        returnNullIfBlank(parsedValues.get(BasicScheduleFields.TRAIN_UID)),
//        InverseDateConverter.convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_FROM)),
//        InverseDateConverter.convert(parsedValues.get(BasicScheduleFields.DATE_RUNS_TO)),
//        DaysOfWeekBitmaskConverter.convert(parsedValues.get(BasicScheduleFields.DAYS_RUN)),
//        LiteralLookup.lookup(BankHolidayRunning.class,
//            parsedValues.get(BasicScheduleFields.BANK_HOLIDAY_RUNNING)).orElse(null),
//
//        );
//
////    return new BasicSchedule(throwIfNullOrBlank(parsedValues.get(HeaderFields.FILE_IDENTITY)),
////        DateConverter.convert(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)),
////        TimeConverter.convert(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)),
////        throwIfNullOrBlank(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)),
////        returnNullIfBlank(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)),
////        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
////            .orElse(null),
////        StringToCharacterConverter.convert(parsedValues.get(HeaderFields.VERSION)).orElse(null),
////        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_START_DATE)),
////        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_END_DATE)),
////        returnNullIfBlank(parsedValues.get(HeaderFields.SPARE)));
//
//    return null;
//  }
//}
