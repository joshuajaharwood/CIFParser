package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Map;
import java.util.Optional;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits
  BasicScheduleParser
  
//  AssociationParser,
//  BasicScheduleExtendedParser, , ChangeEnRouteParser, HeaderParser,
//  IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser, TiplocAmendParser,
//  TiplocDeleteParser, TiplocInsertParser, TrailerParser 
{

  T parse(String record);
}