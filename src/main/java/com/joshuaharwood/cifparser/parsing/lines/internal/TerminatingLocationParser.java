package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.FiveDigitTimeConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.TerminatingLocationFields;
import java.util.Map;

public final class TerminatingLocationParser implements
    RecordSpecificParser<TerminatingLocation> {

  @Override
  public TerminatingLocation parse(String record) {
    final Map<TerminatingLocationFields, String> parsedValues = StringParser.parse(record,
        TerminatingLocationFields.values());

    return new TerminatingLocation(ifPresent(parsedValues.get(TerminatingLocationFields.LOCATION)).orElse(
        null),
        FiveDigitTimeConverter.apply(parsedValues.get(TerminatingLocationFields.SCHEDULED_ARRIVAL_TIME))
                              .orElse(null),
        ZeroSafeTimeConverter.apply(parsedValues.get(TerminatingLocationFields.PUBLIC_ARRIVAL_TIME))
                             .orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.PLATFORM)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.PATH)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.ACTIVITY)).orElse(null),
        ifPresent(parsedValues.get(TerminatingLocationFields.SPARE)).orElse(null));
  }
}
