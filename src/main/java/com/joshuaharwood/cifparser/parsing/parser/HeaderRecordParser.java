package com.joshuaharwood.cifparser.parsing.parser;

import static com.joshuaharwood.cifparser.parsing.model.converters.StringToCharacterConverter.parseStringToCharacter;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import com.joshuaharwood.cifparser.parsing.model.converters.DateConverter;
import com.joshuaharwood.cifparser.parsing.model.converters.TimeConverter;
import java.util.Map;

public final class HeaderRecordParser implements RecordParser<HeaderRecord> {

  public HeaderRecord parse(String record) {
    final Map<HeaderFields, String> parsedValues = StringParser.parse(record,
        HeaderFields.values());

    return new HeaderRecord(throwIfNullOrBlank(parsedValues.get(HeaderFields.FILE_IDENTITY)),
        DateConverter.parse(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)),
        TimeConverter.parse(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)),
        throwIfNullOrBlank(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)),
        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
            .orElse(null),
        parseStringToCharacter(parsedValues.get(HeaderFields.VERSION)).orElse(null),
        DateConverter.parse(parsedValues.get(HeaderFields.EXTRACT_START_DATE)),
        DateConverter.parse(parsedValues.get(HeaderFields.EXTRACT_END_DATE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.SPARE)));
  }
}
