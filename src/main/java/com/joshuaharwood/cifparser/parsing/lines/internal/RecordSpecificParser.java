package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits AssociationParser,
    BasicScheduleExtendedParser, BasicScheduleParser, ChangeEnRouteParser, HeaderParser,
    IntermediateLocationParser, OriginLocationParser, TerminatingLocationParser, TiplocAmendParser,
    TiplocDeleteParser, TiplocInsertParser, TrailerParser {

  T parse(String record);

  default Optional<String> ifPresent(String s) {
    if (s == null || s.isBlank()) {
      return Optional.empty();
    }

    return Optional.of(s.trim());
  }

  default @Nullable Character parseChar(@NotNull String s) {
    if (s.length() > 1) {
      throw new IllegalArgumentException("Given string was longer than one character.");
    }

    if (s.isBlank()) {
      return null;
    }

    return s.charAt(0);
  }
}
