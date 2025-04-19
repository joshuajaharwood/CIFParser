//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import com.google.common.collect.ImmutableList;
//import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class StringParser {
//
//  private StringParser() {
//  }
//
////  public static <T extends RowField<T>> List<ParsedRowField<T>> parseRow(String record,
////    List<T> rowFields) {
////
////    var builder = ImmutableList.<ParsedRowField<T>>builder();
////
////    for (T rowField : rowFields) {
////      builder.add(parseSingleField(record.substring(rowField.startIndex(), rowField.endIndex()),
////        rowField));
////    }
////
////    return builder.build();
////  }
////
////  @Deprecated
////  public static <T extends RowField<?>> Map<T, String> parse(String record, List<T> rowFields) {
////    Objects.requireNonNull(record);
////    Objects.requireNonNull(rowFields);
////    validateLengths(rowFields, record.length());
////
////    final var hashMap = new HashMap<T, String>();
////
////    int startingIndex = 0;
////
////    for (T field : rowFields) {
////      hashMap.put(field, record.substring(startingIndex, startingIndex += field.length()));
////    }
////
////    return hashMap;
////  }
//
////  @Deprecated
////  public static <T extends RowField<?>> Map<T, String> parse(String record, T[] rowFields) {
////    return parse(record, List.of(rowFields));
////  }
////
////  private static <T extends RowField<?>> void validateLengths(List<T> lengths, int targetLength) {
////    if (!fieldsAreCorrectLengthTotal(lengths, targetLength)) {
////      if (lengths.isEmpty()) {
////        throw new IllegalArgumentException("RowField argument must include at least one element.");
////      }
////
////      throw new IllegalArgumentException(
////        "Given lengths did not sum up to a full record's length. [Given lengths: %s] [Record length: %d]".formatted(
////          lengths.stream()
////            .map(RowField::length)
////            .map(Object::toString)
////            .collect(Collectors.joining(", ")),
////          targetLength));
////    }
////  }
////
////  private static <T extends RowField<?>> boolean fieldsAreCorrectLengthTotal(List<T> fields,
////    int targetLength) {
////    return fields.stream().mapToInt(RowField::length).sum() == targetLength;
////  }
////
////  public static <T extends RowField<T>> ParsedRowField<T> parseSingleField(String field,
////    T rowField) {
////    return new ParsedRowField<>(rowField, rowField.convert(field));
////  }
//}
