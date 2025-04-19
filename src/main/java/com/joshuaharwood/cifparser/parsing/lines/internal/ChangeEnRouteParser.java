//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;
//import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookupSet;
//
//import com.joshuaharwood.cifparser.parsing.lines.model.ChangeEnRoute;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
//import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.ChangeEnRouteFields;
//import java.util.Map;
//
//public final class ChangeEnRouteParser implements RecordSpecificParser<ChangeEnRoute> {
//
//  @Override
//  public ChangeEnRoute parse(String record) {
//    final Map<ChangeEnRouteFields, String> parsedValues = StringParser.parse(record,
//        ChangeEnRouteFields.values());
//
//    return new ChangeEnRoute(ifPresent(parsedValues.get(ChangeEnRouteFields.LOCATION)).orElse(null),
//        lookup(TrainCategory.class, parsedValues.get(ChangeEnRouteFields.TRAIN_CATEGORY)).orElse(
//            null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.TRAIN_IDENTITY)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.HEADCODE)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.COURSE_INDICATOR)).map(Byte::valueOf)
//            .orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE)).orElse(
//            null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.BUSINESS_SECTOR)).orElse(null),
//        lookup(PowerType.class, parsedValues.get(ChangeEnRouteFields.POWER_TYPE)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.TIMING_LOAD)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.SPEED)).map(Integer::valueOf).orElse(null),
//        lookupSet(OperatingCharacteristics.class,
//            parsedValues.get(ChangeEnRouteFields.OPERATING_CHARACTERISTICS)),
//        lookup(SeatingClass.class, parsedValues.get(ChangeEnRouteFields.TRAIN_CLASS)).orElse(null),
//        lookup(Sleepers.class, parsedValues.get(ChangeEnRouteFields.SLEEPERS)).orElse(null),
//        lookup(Reservations.class, parsedValues.get(ChangeEnRouteFields.RESERVATIONS)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.CONNECT_INDICATOR)).orElse(null),
//        lookup(CateringCode.class,
//            parsedValues.get(ChangeEnRouteFields.CATERING_CODE)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.SERVICE_BRANDING)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.TRACTION_CLASS)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.UIC_CODE)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.RETAIL_SERVICE_ID)).orElse(null),
//        ifPresent(parsedValues.get(ChangeEnRouteFields.SPARE)).orElse(null));
//  }
//}
