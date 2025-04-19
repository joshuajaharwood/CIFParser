//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;
//
//import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
//import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
//import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
//import java.util.Map;
//import java.util.Objects;
//import org.jspecify.annotations.Nullable;
//
//public class ParsingHelpers {
//
//  @Nullable
//  public static Character parseChar(String s) {
//    if (s.length() > 1) {
//      throw new IllegalArgumentException("Given string was longer than one character.");
//    }
//
//    if (s.isBlank()) {
//      return null;
//    }
//
//    return s.charAt(0);
//  }
//
//  static <T extends RowField> String required(
//    Map<T, String> parsedValues,
//    T parseKey) {
//
//    //noinspection DataFlowIssue IntelliJ isn't smart enough to understand that this can't return null.
//    return getValue(parsedValues, parseKey, true);
//  }
//
//  /**
//   * Syntactic sugar to show that a field can be null in source data.
//   */
//  static <T> @Nullable T optional(@Nullable T arg) {
//    return arg;
//  }
//
//  static <E extends Enum<E> & Literal, K extends RowField> E requiredLookup(Map<K, String> parsedValues,
//    K parseKey,
//    Class<E> literalType) {
//
//    String requiredValue = required(parsedValues, parseKey);
//
//    // If this is null, we couldn't find the literal!
//    return Objects.requireNonNull(lookup(literalType, requiredValue));
//  }
//
//  private static @Nullable <T extends RowField> String getValue(Map<T, String> parsedValues,
//    T key,
//    boolean required) {
//    var value = parsedValues.get(key);
//
//    if (value == null && required) {
//      throw new RequiredPropertyMissingException(key.name(), parsedValues);
//    }
//
//    return value;
//  }
//}
