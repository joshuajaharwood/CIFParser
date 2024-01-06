package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import java.util.EnumMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class CifLineParser {

  private final Map<RecordIdentity, RecordSpecificParser<?>> parsers;

  public CifLineParser() {
    this.parsers = new EnumMap<>(RecordIdentity.class);
    constructParserMap();
  }

  public CifRecord parseLine(@NotNull String record) {
    final RecordIdentity identity = LiteralLookup.lookup(RecordIdentity.class,
                                                     record.substring(0, 2))
                                                 .orElseThrow(() -> new IllegalArgumentException(
                                                     "A record's identity cannot be blank."));

    return parsers.get(identity).parse(record);
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
