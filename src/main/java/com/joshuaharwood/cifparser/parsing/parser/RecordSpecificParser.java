package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public sealed interface RecordSpecificParser<T extends CifRecord> permits AssociationSpecificParser,
    BasicScheduleExtendedSpecificParser, BasicScheduleSpecificParser, ChangeEnRouteSpecificParser,
    HeaderSpecificParser,
    IntermediateLocationSpecificParser, OriginLocationSpecificParser,
    TerminatingLocationSpecificParser, TiplocAmendSpecificParser,
    TiplocDeleteSpecificParser, TiplocInsertSpecificParser, TrailerSpecificParser {

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
