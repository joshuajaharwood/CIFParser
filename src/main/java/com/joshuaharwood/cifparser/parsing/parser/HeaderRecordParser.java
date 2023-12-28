package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.model.converters.DateConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.StringToCharacterConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.TimeConverter;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import java.util.Map;

public final class HeaderRecordParser implements RecordParser<HeaderRecord> {

  public HeaderRecord parse(String record) {
    final Map<HeaderFields, String> parsedValues = StringParser.parse(record,
        HeaderFields.values());

    return new HeaderRecord(throwIfNullOrBlank(parsedValues.get(HeaderFields.FILE_IDENTITY)),
        DateConverter.convert(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)),
        TimeConverter.convert(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)),
        throwIfNullOrBlank(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)),
        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
            .orElse(null),
        StringToCharacterConverter.convert(parsedValues.get(HeaderFields.VERSION)).orElse(null),
        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_START_DATE)),
        DateConverter.convert(parsedValues.get(HeaderFields.EXTRACT_END_DATE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.SPARE)));
  }
}
