package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.TerminatingLocation;
import com.joshuaharwood.cifparser.parsing.model.converters.FiveDigitTimeConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.ZeroSafeTimeConverter;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TerminatingLocationFields;
import java.util.Map;

public final class TerminatingLocationSpecificParser implements
    RecordSpecificParser<TerminatingLocation> {

  @Override
  public TerminatingLocation parse(String record) {
    final Map<TerminatingLocationFields, String> parsedValues = StringParser.parse(record,
        TerminatingLocationFields.values());

    return new TerminatingLocation(ifPresent(parsedValues.get(TerminatingLocationFields.LOCATION)).orElse(
        null),
        FiveDigitTimeConverter.convert(parsedValues.get(TerminatingLocationFields.SCHEDULED_ARRIVAL_TIME))
                              .orElse(null),
        ZeroSafeTimeConverter.convert(parsedValues.get(TerminatingLocationFields.SCHEDULED_ARRIVAL_TIME))
                             .orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.PLATFORM)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.PATH)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.ACTIVITY)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.SPARE)).orElse(null));
  }
}
