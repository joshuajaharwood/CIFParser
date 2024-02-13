package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.Header.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DateConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.TimeConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Map;

public final class HeaderParser implements RecordSpecificParser<Header> {

  public Header parse(String record) {
    final Map<HeaderFields, String> parsedValues = StringParser.parse(record,
        HeaderFields.values());

    return new Header(ifPresent(parsedValues.get(HeaderFields.FILE_IDENTITY)).orElseThrow(() -> new RequiredPropertyMissingException(
        HeaderFields.FILE_IDENTITY.getName(),
        record,
        parsedValues)),
        DateConverter.convert(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)).orElse(null),
        TimeConverter.convert(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)).orElse(null),
        ifPresent(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)).orElseThrow(() -> new RequiredPropertyMissingException(
            HeaderFields.CURRENT_FILE_REFERENCE.getName(),
            record,
            parsedValues)),
        ifPresent(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)).orElse(null),
        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
                     .orElse(null),
        ifPresent(parsedValues.get(HeaderFields.VERSION)).map(this::parseChar).orElse(null),
        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_START_DATE)).orElse(null),
        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_END_DATE)).orElse(null),
        ifPresent(parsedValues.get(HeaderFields.SPARE)).orElse(null));
  }
}
