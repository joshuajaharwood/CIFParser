package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/**
 * Responsible for parsing a raw String read from a CIF file into a List of Strings of the correct
 * lengths.
 */
public class RawStringParser {

  private RawStringParser() {
  }

  /**
   * @param record  The raw CIF row to be parsed.
   * @param lengths An ordered {@link List<Integer>} containing the constant lengths of each field
   *                in the CIF field type.
   * @return A {@link List<String>} containing {@code record} split up in into chunks of sizes given
   * by the {@code lengths} argument.
   * @throws IllegalArgumentException if the sum of the given lengths is not equal to the length of
   *                                  the record.
   * @throws NullPointerException     if the record or lengths argument are {@code null}.
   * @apiNote The given {@link List<Integer>} of lengths must be equal to the length of the given
   * data. Since CIF data rows are 80 characters wide, the sum of {@code lengths} must equal 80.
   * Whitespace should not be trimmed from the raw data.
   */
  public static @NotNull List<String> parse(String record, List<Integer> lengths) {
    Objects.requireNonNull(record);
    Objects.requireNonNull(lengths);
    validateLengths(lengths, record.length());

    final var substrings = new ArrayList<String>();

    int startingIndex = 0;

    for (final Integer length : lengths) {
      substrings.add(record.substring(startingIndex, startingIndex += length));
    }

    return substrings;
  }

  public static @NotNull Optional<RecordIdentity> parseRecordIdentity(String record) {
    Objects.requireNonNull(record);

    if (record.length() < 2) {
      throw new IllegalArgumentException(
          "Given record strings must be at least 2 characters to establish their RecordIdentity.");
    }

    return LiteralLookup.lookup(RecordIdentity.class, record.substring(0, 2));
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