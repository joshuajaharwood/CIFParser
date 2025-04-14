package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException.ParserPropertyMetadata;
import java.util.Optional;
import java.util.function.Supplier;
import org.jspecify.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits AssociationParser,
  BasicScheduleExtendedParser, BasicScheduleParser, ChangeEnRouteParser, HeaderParser,
  IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser, TiplocAmendParser,
  TiplocDeleteParser, TiplocInsertParser, TrailerParser {

  T parse(String record);

  default Optional<String> ifPresent(String s) {
    if (s.isBlank()) {
      return Optional.empty();
    }

    return Optional.of(s.trim());
  }

  default @Nullable Character parseChar(String s) {
    if (s.length() > 1) {
      throw new IllegalArgumentException("Given string was longer than one character.");
    }

    if (s.isBlank()) {
      return null;
    }

    return s.charAt(0);
  }


  default <U> U required(@Nullable U arg, Supplier<ParserPropertyMetadata> exceptionSupplier) {
    if (arg == null) {
      throw new RequiredPropertyMissingException(exceptionSupplier.get());
    }

    return arg;
  }
}