package com.joshuaharwood.cifparser.records.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class RawStringParser {

  private static final int RECORD_LENGTH = 80;

  private RawStringParser() {
  }

  public static @NotNull List<String> parse(String record, List<Integer> lengths) {
    Objects.requireNonNull(record);
    Objects.requireNonNull(lengths);
    validateLengths(lengths, record.length());

    final var substrings = new ArrayList<String>();

    int startingIndex = 0;

    for (final Integer length : lengths) {
      substrings.add(record.substring(startingIndex, startingIndex += length));
    }

    // Remove RecordIdentity
    substrings.removeFirst();

    return substrings;
  }

  private static void validateLengths(List<Integer> lengths, int rowLength) {
    if (!lengthsAreCorrectTotal(lengths, rowLength)) {
      throw new IllegalArgumentException(
          "Given lengths did not sum up to a full record's length. [Given lengths: %s] [Record length: %d]".formatted(
              lengths.stream().map(Object::toString).collect(Collectors.joining(", ")),
              rowLength));
    }
  }

  private static boolean lengthsAreCorrectTotal(List<Integer> lengths, int rowLength) {
    return lengths.stream().mapToInt(Integer::valueOf).sum() == rowLength;
  }
}