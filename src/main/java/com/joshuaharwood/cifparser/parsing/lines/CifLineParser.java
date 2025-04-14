package com.joshuaharwood.cifparser.parsing.lines;

import com.joshuaharwood.cifparser.parsing.lines.internal.AssociationParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.BasicScheduleExtendedParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.BasicScheduleParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.ChangeEnRouteParser;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.CifLineParserException;
import com.joshuaharwood.cifparser.parsing.lines.internal.HeaderParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.IntermediateLocationParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.OriginLocationParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.RecordSpecificParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.TerminatingLocationParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.TiplocAmendParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.TiplocDeleteParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.TiplocInsertParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.TrailerParser;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
import java.util.EnumMap;
import java.util.Map;

public class CifLineParser {

  private final Map<RecordIdentity, RecordSpecificParser<?>> parsers;

  public CifLineParser() {
    this.parsers = new EnumMap<>(RecordIdentity.class);
    constructParserMap();
  }

  public CifRecord parseLine(String record) {
    if (record.isBlank() || record.trim().length() < 2) {
      throw new IllegalArgumentException(
          "Record must be at least 2 characters to establish RecordIdentity.");
    }

    if (record.length() != 80) {
      throw new IllegalArgumentException(
          "CIF records should be 80 characters, including whitespace.");
    }

    try {
      final RecordIdentity identity = LiteralLookup.lookup(RecordIdentity.class,
              record.substring(0, 2))
          .orElseThrow(() -> new IllegalArgumentException("A record's identity cannot be blank."));

      return parsers.get(identity).parse(record);
    } catch (Exception e) {
      throw new CifLineParserException("Failed to parse record. [Record: %s]".formatted(record), e);
    }
  }

  private void constructParserMap() {
    for (RecordIdentity recordIdentity : RecordIdentity.values()) {
      RecordSpecificParser<?> parser = switch (recordIdentity) {
        case HEADER_RECORD -> new HeaderParser();
        case TIPLOC_INSERT_RECORD -> new TiplocInsertParser();
        case TIPLOC_AMEND_RECORD -> new TiplocAmendParser();
        case TIPLOC_DELETE_RECORD -> new TiplocDeleteParser();
        case ASSOCIATION_RECORD -> new AssociationParser();
        case BASIC_SCHEDULE -> new BasicScheduleParser();
        case BASIC_SCHEDULE_EXTRA_DETAILS -> new BasicScheduleExtendedParser();
        case ORIGIN_LOCATION -> new OriginLocationParser();
        case INTERMEDIATE_LOCATION -> new IntermediateLocationParser();
        case CHANGE_EN_ROUTE -> new ChangeEnRouteParser();
        case TERMINATING_LOCATION -> new TerminatingLocationParser();
        case TRAILER_RECORD -> new TrailerParser();
        case TRAIN_SPECIFIC_NOTE, LOCATION_SPECIFIC_NOTE -> null;
      };

      if (parser != null) {
        parsers.put(recordIdentity, parser);
      }
    }
  }
}
