package com.joshuaharwood.cifparser.records.parser;

import static com.joshuaharwood.cifparser.records.model.parsers.StringToCharacterParser.parseStringToCharacter;

import com.joshuaharwood.cifparser.records.model.HeaderRecord;
import com.joshuaharwood.cifparser.records.model.HeaderRecord.UpdateIndicator;
import com.joshuaharwood.cifparser.records.model.literals.LiteralLookup;
import com.joshuaharwood.cifparser.records.model.parsers.DateParser;
import com.joshuaharwood.cifparser.records.model.parsers.TimeParser;
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

    return new HeaderRecord(rawStrings.get(0),
        DateParser.parse(rawStrings.get(1)),
        TimeParser.parse(rawStrings.get(2)),
        rawStrings.get(3),
        rawStrings.get(4),
        LiteralLookup.lookup(UpdateIndicator.class, rawStrings.get(5)).orElse(null),
        parseStringToCharacter(rawStrings.get(6)).orElse(null),
        DateParser.parse(rawStrings.get(7)),
        DateParser.parse(rawStrings.get(8)),
        rawStrings.get(9));
  }

  @Override
  public Class<HeaderRecord> getRecordType() {
    return HeaderRecord.class;
  }
}
