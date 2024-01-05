package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class DaysOfWeekBitmaskConverter {

  //TODO: rewrite this now it returns a set!

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
  public static Optional<Set<DayOfWeek>> convert(String stringBitmask) {
    Objects.requireNonNull(stringBitmask, "Days-of-week bitmask must not be null.");

    if (stringBitmask.length() != 7) {
      throw new IllegalArgumentException("Days-of-week bitmask must be 7 binary digits.");
    }

    byte bitmask = Byte.parseByte(stringBitmask, 2);

    EnumSet<DayOfWeek> daysOfWeek = EnumSet.noneOf(DayOfWeek.class);

    if (getBit(bitmask, 6)) {
      daysOfWeek.add(DayOfWeek.MONDAY);
    }

    if (getBit(bitmask, 5)) {
      daysOfWeek.add(DayOfWeek.TUESDAY);
    }

    if (getBit(bitmask, 4)) {
      daysOfWeek.add(DayOfWeek.WEDNESDAY);
    }

    if (getBit(bitmask, 3)) {
      daysOfWeek.add(DayOfWeek.THURSDAY);
    }

    if (getBit(bitmask, 2)) {
      daysOfWeek.add(DayOfWeek.FRIDAY);
    }

    if (getBit(bitmask, 1)) {
      daysOfWeek.add(DayOfWeek.SATURDAY);
    }

    if (getBit(bitmask, 0)) {
      daysOfWeek.add(DayOfWeek.SUNDAY);
    }

    return Optional.of(Collections.unmodifiableSet(daysOfWeek));
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
