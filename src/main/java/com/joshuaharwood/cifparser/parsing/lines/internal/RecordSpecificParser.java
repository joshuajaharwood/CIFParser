package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Map;
import java.util.Optional;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits AssociationParser,
  BasicScheduleExtendedParser, BasicScheduleParser, ChangeEnRouteParser, HeaderParser,
  IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser, TiplocAmendParser,
  TiplocDeleteParser, TiplocInsertParser, TrailerParser {

  T parse(String record);

//  default Optional<String> ifPresent(String s) {
//    if (s.isBlank()) {
//      return Optional.empty();
//    }
//
//    return Optional.of(s.trim());
//  }
//
//  default @Nullable Character parseChar(String s) {
//    if (s.length() > 1) {
//      throw new IllegalArgumentException("Given string was longer than one character.");
//    }
//
//    if (s.isBlank()) {
//      return null;
//    }
//
//    return s.charAt(0);
//  }
//
//
//  default String required(
//    Map<?, String> parsedValues,
//    String parseKey) {
//    
//    String parsedValue = parsedValues.get(parseKey);
//    
//    if (parsedValue == null) {
//      throw new RequiredPropertyMissingException(parseKey,
//        parsedValues);
//    }
//
//    return parsedValue;
//  }
//
//  default <E extends Enum<E> & Literal> E requiredLookup(Map<?, String> parsedValues,
//    String parseKey,
//    Class<E> literalType) {
//    
//    String requiredValue = required(parsedValues, parseKey);
//
//    // If this is null, we couldn't find the literal!
//    return lookup(literalType, requiredValue);
//  }
}