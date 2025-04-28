package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;

public sealed interface RecordSpecificParser<T extends CifRecord> permits BasicScheduleParser,
  HeaderParser, TrailerParser, TiplocAmendParser, BasicScheduleExtendedParser

//  AssociationParser,
//  , , ChangeEnRouteParser, 
//  IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser,
//  TiplocDeleteParser, TiplocInsertParser 
{

  T parse(String record);
}
