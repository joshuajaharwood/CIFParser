package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;

public sealed interface RecordSpecificParser<T extends CifRecord> permits
  HeaderParser,
  BasicScheduleParser,
  BasicScheduleExtendedParser,
  AssociationParser,
  OriginLocationParser,
  IntermediateLocationParser,
  ChangeEnRouteParser,
  TerminatingLocationParser,
  TiplocInsertParser,
  TiplocAmendParser,
  TiplocDeleteParser,
  TrailerParser {

  T parse(String record);
}
