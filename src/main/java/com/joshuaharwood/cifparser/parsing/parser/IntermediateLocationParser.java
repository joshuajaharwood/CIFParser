package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.IntermediateLocation;
import com.joshuaharwood.cifparser.parsing.model.converters.FiveDigitTimeConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.ZeroSafeTimeConverter;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.IntermediateLocationFields;
import java.util.Map;

public final class IntermediateLocationParser implements
    RecordSpecificParser<IntermediateLocation> {

  @Override
  public IntermediateLocation parse(String record) {
    final Map<IntermediateLocationFields, String> parsedValues = StringParser.parse(record,
        IntermediateLocationFields.values());

    return new IntermediateLocation(ifPresent(parsedValues.get(IntermediateLocationFields.LOCATION)).orElse(
        null),
        FiveDigitTimeConverter
            .convert(parsedValues.get(IntermediateLocationFields.SCHEDULED_ARRIVAL_TIME))
            .orElse(null),
        FiveDigitTimeConverter
            .convert(parsedValues.get(IntermediateLocationFields.SCHEDULED_DEPARTURE_TIME))
            .orElse(null),
        FiveDigitTimeConverter
            .convert(parsedValues.get(IntermediateLocationFields.SCHEDULED_PASS))
            .orElse(null),
        ZeroSafeTimeConverter
            .convert(parsedValues.get(IntermediateLocationFields.PUBLIC_ARRIVAL))
            .orElse(null),
        ZeroSafeTimeConverter
            .convert(parsedValues.get(IntermediateLocationFields.PUBLIC_DEPARTURE))
            .orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.PLATFORM)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.LINE)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.PATH)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.ACTIVITY)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.ENGINEERING_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.PATHING_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.PERFORMANCE_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(IntermediateLocationFields.SPARE)).orElse(null));
  }
}
