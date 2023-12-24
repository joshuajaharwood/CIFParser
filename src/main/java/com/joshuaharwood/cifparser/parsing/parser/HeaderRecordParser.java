package com.joshuaharwood.cifparser.parsing.parser;

import static com.joshuaharwood.cifparser.parsing.model.parsers.StringToCharacterParser.parseStringToCharacter;

import com.joshuaharwood.cifparser.parsing.model.HeaderRecord;
import com.joshuaharwood.cifparser.parsing.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import com.joshuaharwood.cifparser.parsing.model.parsers.DateParser;
import com.joshuaharwood.cifparser.parsing.model.parsers.TimeParser;
import java.util.List;

public final class HeaderRecordParser implements RecordParser<HeaderRecord> {

  public static final List<Integer> HEADER_RECORD_LENGTHS = List.of(2,
      20,
      6,
      4,
      7,
      7,
      1,
      1,
      6,
      6,
      20);

  public HeaderRecord parse(String record) {

    var rawStrings = RawStringParser.parse(record, HEADER_RECORD_LENGTHS);

    return new HeaderRecord(throwIfNullOrBlank(rawStrings.get(1)),
        DateParser.parse(rawStrings.get(2)),
        TimeParser.parse(rawStrings.get(3)),
        throwIfNullOrBlank(rawStrings.get(4)),
        returnNullIfBlank(rawStrings.get(5)),
        LiteralLookup.lookup(UpdateIndicator.class, rawStrings.get(6)).orElse(null),
        parseStringToCharacter(rawStrings.get(7)).orElse(null),
        DateParser.parse(rawStrings.get(8)),
        DateParser.parse(rawStrings.get(9)),
        returnNullIfBlank(rawStrings.get(10)));
  }

  @Override
  public Class<HeaderRecord> getRecordType() {
    return HeaderRecord.class;
  }


}
