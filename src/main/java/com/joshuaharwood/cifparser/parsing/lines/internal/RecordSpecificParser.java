package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.BasicScheduleExtendedFields;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import java.util.Optional;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits AssociationParser,
  BasicScheduleExtendedParser, BasicScheduleParser, ChangeEnRouteParser, HeaderParser,
  IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser, TiplocAmendParser,
  TiplocDeleteParser, TiplocInsertParser, TrailerParser {

  T parse(String record);

  default <U> U ifPresent(@Nullable U arg,
    Function<U, U> notNullHandler,
    Consumer<> nullHandler) {
    if (arg != null) {
      return notNullHandler.apply(arg);
    }

    throw new RequiredPropertyMissingException(
      BasicScheduleExtendedFields.ATOC_CODE.getName(),
      record,
      parsedValues);

    return nullHandler.apply(arg);
  }

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
  
  default <U> U required(U arg) {
    if (arg == null) {
      throw new RequiredPropertyMissingException()
    }
    
    return Objects.require
  }

  
}