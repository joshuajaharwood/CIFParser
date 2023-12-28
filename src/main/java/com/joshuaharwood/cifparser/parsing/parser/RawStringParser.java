package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/**
 * Responsible for parsing a raw {@link String} read from a CIF file into a List of Strings of the
 * correct lengths.
 */
public class RawStringParser<T extends Enum<T> & RowField> {

  private final List<T> fields;
  private final Class<T> clazz;

  public RawStringParser(List<T> fields, Class<T> clazz) {
    Objects.requireNonNull(fields);
    validateLengths(fields);
    this.fields = fields;
    this.clazz = clazz;
  }

  public RawStringParser(T[] fields, Class<T> clazz) {
    this(List.of(fields), clazz);
  }

  // todo remove val and use method generic!!
  public @NotNull Map<T, String> parse(String record) {
    Objects.requireNonNull(record);

    final var newMap = new EnumMap<T, String>(clazz);

    int startingIndex = 0;

    for (T field : fields) {
      newMap.put(field, record.substring(startingIndex, startingIndex += field.getLength()));
    }

    return newMap;
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

  private void validateLengths(List<T> lengths) {
    if (!fieldsAreCorrectLengthTotal(lengths)) {
      throw new IllegalArgumentException(
          "Given lengths did not sum up to a full record's length. [Given lengths: %s] [Record length: %d]".formatted(
              lengths.stream().map(Object::toString).collect(Collectors.joining(", ")),
              80));
    }
  }

  private boolean fieldsAreCorrectLengthTotal(List<T> fields) {
    return fields.stream().mapToInt(RowField::getLength).sum() == 80;
  }
}