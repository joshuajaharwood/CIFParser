package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DaysOfWeekBitmaskConverter {

  /**
   * Converts days-of-the-week bitmasks to {@link Map}s representing their data.
   *
   * @param stringBitmask A 7-digit bitmask where the left-most digit represents Monday, and the
   *                      right-most digit Sunday. A zero is false, and a one is true.
   * @return An {@link Optional} of a {@link Map} of {@link DayOfWeek} to {@link Boolean}s where
   * zeroes are false, and ones are true. An empty {@link Optional} will be returned if the given
   * bitmask is blank or {@code null}.
   * @throws NullPointerException     if {@code stringBitmask} is {@code null}.
   * @throws IllegalArgumentException if {@code stringBitmask} is longer or shorter than 7
   *                                  characters.
   */
  public static Optional<Map<DayOfWeek, Boolean>> convert(String stringBitmask) {
    Objects.requireNonNull(stringBitmask, "Days-of-week bitmask must not be null.");

    if (stringBitmask.length() != 7) {
      throw new IllegalArgumentException("Days-of-week bitmask must be 7 binary digits.");
    }

    byte bitmask = Byte.parseByte(stringBitmask, 2);

    Map<DayOfWeek, Boolean> daysOfWeek = new EnumMap<>(DayOfWeek.class);
    daysOfWeek.put(DayOfWeek.MONDAY, getBit(bitmask, 6));
    daysOfWeek.put(DayOfWeek.TUESDAY, getBit(bitmask, 5));
    daysOfWeek.put(DayOfWeek.WEDNESDAY, getBit(bitmask, 4));
    daysOfWeek.put(DayOfWeek.THURSDAY, getBit(bitmask, 3));
    daysOfWeek.put(DayOfWeek.FRIDAY, getBit(bitmask, 2));
    daysOfWeek.put(DayOfWeek.SATURDAY, getBit(bitmask, 1));
    daysOfWeek.put(DayOfWeek.SUNDAY, getBit(bitmask, 0));

    return Optional.of(Collections.unmodifiableMap(daysOfWeek));
  }

  /**
   * Returns whether a bit is set in a bitmask.
   *
   * @param bitmask  The bitmask to get a bit from.
   * @param position The index of the bit to retrieve. Indices are counted from the end of the
   *                 bitmask (e.g. in 1110, position zero equals {@code false}, or {@code zero})
   * @return {@code true} if the bit is one, {@code false} if zero.
   */
  private static boolean getBit(byte bitmask, int position) {
    return (bitmask & (1L << position)) != 0;
  }
}
