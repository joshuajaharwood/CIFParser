package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;
import java.util.Optional;

/**
 * Converts 5-digit SCHEDULE times, where a 4-digit time can be appended with an 'H' (meaning 'half'
 * - the 'H' indicates that you should add half a minute to the time).
 *
 * @apiNote You will most often see 5-digit time when dealing with train scheduling, as scheduling
 * granularity is half a minute. // TODO: Find a documentation reference for this
 */
public class FiveDigitTimeConverter implements Converter<Optional<LocalTime>> {

  private static final FiveDigitTimeConverter INSTANCE = new FiveDigitTimeConverter();

  private static final TimeConverter TIME_CONVERTER = TimeConverter.getInstance();

  private static final char HALF_MINUTE_INDICATOR = 'H';

  private FiveDigitTimeConverter() {
  }

  public static FiveDigitTimeConverter getInstance() {
    return INSTANCE;
  }

  private static Optional<LocalTime> parseFiveDigitTime(String input) {
    final var lastChar = input.charAt(4);

    if (!Character.isWhitespace(lastChar)) {
      if (lastChar == HALF_MINUTE_INDICATOR) {
        return TIME_CONVERTER.apply(input.substring(0, 4))
          .map(localTime -> localTime.withSecond(30));
      }

      throw new IllegalArgumentException("Unknown character appended to 5-digit time. [Input: %s]".formatted(
        input));
    }

    return TIME_CONVERTER.apply(input);
  }

  public Optional<LocalTime> apply(String input) {
    return switch (input.length()) {
      case 4 -> TIME_CONVERTER.apply(input);
      case 5 -> parseFiveDigitTime(input);
      default ->
        throw new IllegalArgumentException("Passed in time Strings must be 5 digits. [Input: %s]".formatted(
          input));
    };
  }
}
