package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.OriginLocation;
import com.joshuaharwood.cifparser.parsing.model.converters.TimeConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.ZeroSafeTimeConverter;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.OriginLocationFields;
import java.util.Map;

public final class OriginLocationSpecificParser implements RecordSpecificParser<OriginLocation> {

  @Override
  public OriginLocation parse(String record) {
    final Map<OriginLocationFields, String> parsedValues = StringParser.parse(record,
        OriginLocationFields.values());

    return new OriginLocation(ifPresent(parsedValues.get(OriginLocationFields.LOCATION)).orElseThrow(
        () -> new RequiredPropertyMissingException(OriginLocationFields.LOCATION.getName(),
            record,
            parsedValues)),
        TimeConverter
            .convert(parsedValues.get(OriginLocationFields.SCHEDULED_DEPARTURE_TIME).trim())
            .orElse(null),
        ZeroSafeTimeConverter
            .convert(parsedValues.get(OriginLocationFields.PUBLIC_DEPARTURE_TIME))
            .orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.PLATFORM)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.LINE)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.ENGINEERING_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.PATHING_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.ACTIVITY)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.PERFORMANCE_ALLOWANCE)).orElse(null),
        ifPresent(parsedValues.get(OriginLocationFields.SPARE)).orElse(null));
  }
}
