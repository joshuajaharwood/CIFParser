//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
//import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.OriginLocationFields;
//import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
//import java.util.Map;
//
//public final class OriginLocationParser implements RecordSpecificParser<OriginLocation> {
//
//  @Override
//  public OriginLocation parse(String record) {
//    final Map<OriginLocationFields, String> parsedValues = StringParser.parse(record,
//        OriginLocationFields.values());
//
//    return new OriginLocation(ifPresent(parsedValues.get(OriginLocationFields.LOCATION)).orElseThrow(
//        () -> new RequiredPropertyMissingException(OriginLocationFields.LOCATION.name(),
//          parsedValues)),
//        FiveDigitTimeConverter
//            .apply(parsedValues.get(OriginLocationFields.SCHEDULED_DEPARTURE_TIME).trim())
//            .orElse(null),
//        ZeroSafeTimeConverter
//            .apply(parsedValues.get(OriginLocationFields.PUBLIC_DEPARTURE_TIME))
//            .orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.PLATFORM)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.LINE)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.ENGINEERING_ALLOWANCE)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.PATHING_ALLOWANCE)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.ACTIVITY)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.PERFORMANCE_ALLOWANCE)).orElse(null),
//        ifPresent(parsedValues.get(OriginLocationFields.SPARE)).orElse(null));
//  }
//}
