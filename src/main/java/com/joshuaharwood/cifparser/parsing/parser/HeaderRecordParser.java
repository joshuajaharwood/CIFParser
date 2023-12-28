package com.joshuaharwood.cifparser.parsing.parser;

import static com.joshuaharwood.cifparser.parsing.model.parsers.StringToCharacterParser.parseStringToCharacter;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.HeaderFields;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import com.joshuaharwood.cifparser.parsing.model.parsers.DateParser;
import com.joshuaharwood.cifparser.parsing.model.parsers.TimeParser;
import java.util.List;
import java.util.Map;

public final class HeaderRecordParser implements RecordParser<HeaderRecord> {

  private static final RawStringParser<HeaderFields> parser = new RawStringParser<>(List.of(
      HeaderFields.values()), HeaderFields.class);

  public HeaderRecord parse(String record) {
    final Map<HeaderFields, String> parsedValues = parser.parse(record);

    return new HeaderRecord(throwIfNullOrBlank(parsedValues.get(HeaderFields.FILE_IDENTITY)),
        DateParser.parse(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)),
        TimeParser.parse(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)),
        throwIfNullOrBlank(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)),
        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
            .orElse(null),
        parseStringToCharacter(parsedValues.get(HeaderFields.VERSION)).orElse(null),
        DateParser.parse(parsedValues.get(HeaderFields.EXTRACT_START_DATE)),
        DateParser.parse(parsedValues.get(HeaderFields.EXTRACT_END_DATE)),
        returnNullIfBlank(parsedValues.get(HeaderFields.SPARE)));
  }
}
