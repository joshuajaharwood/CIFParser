package com.joshuaharwood.cifparser.parsing.lines;

import com.joshuaharwood.cifparser.parsing.lines.internal.BasicScheduleParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.CifLineParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CifLineParser {

  private static final BasicScheduleParser BASIC_SCHEDULE_PARSER = new BasicScheduleParser();
  private static final Logger LOG = LoggerFactory.getLogger(CifLineParser.class);
  private static final LiteralConverter<RecordIdentity> CONVERTER = LiteralConverter.create(
    RecordIdentity.class);

//  private static final HeaderParser HEADER_PARSER = new HeaderParser();
//  private static final TiplocInsertParser TIPLOC_INSERT_PARSER = new TiplocInsertParser();
//  private static final TiplocAmendParser TIPLOC_AMEND_PARSER = new TiplocAmendParser();
//  private static final TiplocDeleteParser TIPLOC_DELETE_PARSER = new TiplocDeleteParser();
//  private static final AssociationParser ASSOCIATION_PARSER = new AssociationParser();
//  private static final BasicScheduleExtendedParser BASIC_SCHEDULE_EXTENDED_PARSER = new BasicScheduleExtendedParser();
//  private static final OriginLocationParser ORIGIN_LOCATION_PARSER = new OriginLocationParser();
//  private static final IntermediateLocationParser INTERMEDIATE_LOCATION_PARSER = new IntermediateLocationParser();
//  private static final ChangeEnRouteParser CHANGE_EN_ROUTE_PARSER = new ChangeEnRouteParser();
//  private static final TerminatingLocationParser TERMINATING_LOCATION_PARSER = new TerminatingLocationParser();
//  private static final TrailerParser TRAILER_PARSER = new TrailerParser();

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
      final RecordIdentity identity = CONVERTER.apply(record.substring(0,
        2));

      if (identity == null) {
        throw new IllegalArgumentException("A record's identity cannot be blank.");
      }

      return switch (identity) {
//        case HEADER_RECORD -> HEADER_PARSER.parse(record);
//        case TIPLOC_INSERT_RECORD -> TIPLOC_INSERT_PARSER.parse(record);
//        case TIPLOC_AMEND_RECORD -> TIPLOC_AMEND_PARSER.parse(record);
//        case TIPLOC_DELETE_RECORD -> TIPLOC_DELETE_PARSER.parse(record);
//        case ASSOCIATION_RECORD -> ASSOCIATION_PARSER.parse(record);
        case BASIC_SCHEDULE -> BASIC_SCHEDULE_PARSER.parse(record);
//        case BASIC_SCHEDULE_EXTRA_DETAILS -> BASIC_SCHEDULE_EXTENDED_PARSER.parse(record);
//        case ORIGIN_LOCATION -> ORIGIN_LOCATION_PARSER.parse(record);
//        case INTERMEDIATE_LOCATION -> INTERMEDIATE_LOCATION_PARSER.parse(record);
//        case CHANGE_EN_ROUTE -> CHANGE_EN_ROUTE_PARSER.parse(record);
//        case TERMINATING_LOCATION -> TERMINATING_LOCATION_PARSER.parse(record);
//        case TRAILER_RECORD -> TRAILER_PARSER.parse(record);

        default -> throw new UnsupportedOperationException("Not yet implemented. TEMP");
//        case TRAIN_SPECIFIC_NOTE, LOCATION_SPECIFIC_NOTE ->
//          throw new UnsupportedOperationException("Not yet implemented.");
      };
    } catch (Exception e) {
      throw new CifLineParserException("Failed to parse record. [Record: %s]".formatted(record), e);
    }
  }
}
