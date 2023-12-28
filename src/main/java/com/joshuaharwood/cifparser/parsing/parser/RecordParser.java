package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.CIFRecord;
import java.util.Objects;
import java.util.Optional;

public sealed interface RecordParser<T extends CIFRecord> permits BasicScheduleParser,
    HeaderRecordParser {

  T parse(String record);

  default Optional<String> ifNotBlank(String s) {
    if (s == null || s.isBlank()) {
      return Optional.empty();
    }

    return Optional.of(s.trim());
  }

  private Optional<String> handleBlankOrNull(String s) {
    if (s == null || s.isBlank()) {
      return Optional.empty();
    }

    return Optional.of(s);
  }

  default Optional<Short> parseShort(String s) {
    return handleBlankOrNull(s).map(Short::parseShort);
  }

  default Optional<Byte> parseByte(String s) {
    return handleBlankOrNull(s).map(Byte::parseByte);
  }

  default Optional<Integer> parseInt(String s) {
    return handleBlankOrNull(s).map(Integer::parseInt);
  }

  default Optional<Character> parseChar(String s) {
    Objects.requireNonNull(s);

    if (s.isBlank()) {
      return Optional.empty();
    }

    if (s.length() > 1) {
      throw new IllegalArgumentException("Given string was longer than one character.");
    }

    return Optional.of(s.charAt(0));
  }
}
