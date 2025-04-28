package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;

public sealed interface RecordSpecificParser<T extends CifRecord> permits
  BasicScheduleExtendedParser, BasicScheduleParser, HeaderParser, TiplocAmendParser,
  TiplocDeleteParser, TrailerParser
{

  T parse(String record);
}
