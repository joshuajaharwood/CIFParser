package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.CIFRecord;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public sealed interface RecordParser<T extends CIFRecord> permits BasicScheduleExtendedParser,
    BasicScheduleParser, HeaderParser {

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
