package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class NewRawStringParser {

  public @NotNull <T extends Enum<T> & RowField> Map<T, String> parse(String record,
      List<T> rowFields) {
    Objects.requireNonNull(record);
    Objects.requireNonNull(rowFields);

    // We require at least one rowField for parsing
    if (rowFields.isEmpty()) {
      throw new NoSuchElementException("The given rowFields argument was empty.");
    }

    // We get the first element in the list's type to construct our EnumMap
    @SuppressWarnings("unchecked") final var newMap = new EnumMap<T, String>((Class<T>) rowFields.getFirst()
        .getClass());

    int startingIndex = 0;

    for (T field : rowFields) {
      newMap.put(field, record.substring(startingIndex, startingIndex += field.getLength()));
    }

    return newMap;
  }

  public @NotNull <T extends Enum<T> & RowField> Map<T, String> parse(String record,
      T[] rowFields) {
    return parse(record, List.of(rowFields));
  }
}
