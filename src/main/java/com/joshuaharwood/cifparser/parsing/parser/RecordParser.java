package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.CIFRecord;

public sealed interface RecordParser<T extends CIFRecord> permits HeaderRecordParser {

  T parse(String record);

  default String throwIfNullOrBlank(String s) {
    if (s == null || s.isBlank()) {
      throw new IllegalArgumentException("Given argument cannot be blank or null. [Argument: %s]".formatted(
          s));
    }

    return s;
  }

  default String returnNullIfBlank(String s) {
    if (s == null || s.isBlank()) {
      return null;
    }

    return s;
  }
}