package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class StringParser {

  private StringParser() {
  }

  public static @NotNull <T extends RowField> Map<T, String> parse(String record,
      List<T> rowFields) {
    Objects.requireNonNull(record);
    Objects.requireNonNull(rowFields);
    validateLengths(rowFields, record.length());

    // We require at least one rowField for parsing
    if (rowFields.isEmpty()) {
      throw new NoSuchElementException("The given rowFields argument was empty.");
    }

    final var hashMap = new HashMap<T, String>();

    int startingIndex = 0;

    for (T field : rowFields) {
      hashMap.put(field, record.substring(startingIndex, startingIndex += field.getLength()));
    }

    return hashMap;
  }

  public static @NotNull <T extends RowField> Map<T, String> parse(String record, T[] rowFields) {
    return parse(record, List.of(rowFields));
  }

  public static @NotNull RecordIdentity parseRecordIdentity(String record) {
    Objects.requireNonNull(record);

    // Prevent IndexOutOfBoundsException
    if (record.length() < 2) {
      throw new IllegalArgumentException(
          "Given record strings must be at least 2 characters to establish their RecordIdentity.");
    }

    final var lookupRecordIdentity = record.substring(0, 2);

    return LiteralLookup.lookup(RecordIdentity.class, lookupRecordIdentity)
        .orElseThrow(() -> new IllegalArgumentException(
            "No RecordIdentity could be found for the given value. [Value: %s]".formatted(
                lookupRecordIdentity)));
  }

  private static <T extends RowField> void validateLengths(List<T> lengths, int targetLength) {
    if (!fieldsAreCorrectLengthTotal(lengths, targetLength)) {
      throw new IllegalArgumentException(
          "Given lengths did not sum up to a full record's length. [Given lengths: %s] [Record length: %d]".formatted(
              lengths.stream()
                  .map(RowField::getLength)
                  .map(Object::toString)
                  .collect(Collectors.joining(", ")),
              targetLength));
    }
  }

  private static <T extends RowField> boolean fieldsAreCorrectLengthTotal(List<T> fields,
      int targetLength) {
    return fields.stream().mapToInt(RowField::getLength).sum() == targetLength;
  }
}