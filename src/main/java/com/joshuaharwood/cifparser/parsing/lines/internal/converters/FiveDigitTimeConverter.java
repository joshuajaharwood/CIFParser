package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;

/**
 * Converts 5-digit SCHEDULE times, where a 4-digit time can be appended with an 'H' (meaning 'half'
 * - the 'H' indicates that you should add half a minute to the time).
 *
 * @apiNote You will most often see 5-digit time when dealing with train scheduling, as scheduling
 * granularity is half a minute. // TODO: Find a documentation reference for this
 */
public class FiveDigitTimeConverter implements Converter<LocalTime> {

  private static final FiveDigitTimeConverter INSTANCE = new FiveDigitTimeConverter();

  private static final TimeConverter CONVERTER = TimeConverter.getInstance();

  private static final char HALF_MINUTE_INDICATOR = 'H';

  private FiveDigitTimeConverter() {
  }

  public static FiveDigitTimeConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public LocalTime apply(String input) {
    if (input.length() != 4 && input.length() != 5) {
      throw new IllegalArgumentException("Input must be 4 or 5 digits long. [Input: %s]".formatted(
        input));
    }

    var time = CONVERTER.apply(input.substring(0, 3));

    if (input.length() == 5) {
      if (input.charAt(4) != HALF_MINUTE_INDICATOR) {
        throw new IllegalArgumentException(
          "Unrecognised character appended to 4-digit time. [Input: %s]".formatted(input));
      }

      time = time.withSecond(30);
    }

    return time;
  }
}
