package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class DaysOfWeekBitmaskConverter {

  /**
   * Converts days-of-the-week bitmasks to {@link Set}s representing the days the bitmask
   * represents.
   *
   * @param stringBitmask A 7-digit bitmask where the left-most digit represents Monday, and the
   *                      right-most digit Sunday. A zero is false, and a one is true.
   * @return An {@link Optional} of a {@link Set} of {@link DayOfWeek}s where the day of the week is
   * true in the bitmask or an empty {@link Optional} if the given bitmask is blank or
   * {@code null}.
   * @throws NullPointerException     if {@code stringBitmask} is {@code null}.
   * @throws IllegalArgumentException if {@code stringBitmask} is longer or shorter than 7
   *                                  characters.
   */
  public static Optional<Set<DayOfWeek>> convert(String stringBitmask) {
    Objects.requireNonNull(stringBitmask, "Days-of-week bitmask must not be null.");

    if (stringBitmask.length() != 7) {
      throw new IllegalArgumentException("Days-of-week bitmask must be 7 binary digits.");
    }

    EnumSet<DayOfWeek> daysOfWeek = EnumSet.noneOf(DayOfWeek.class);

    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      if (getBit(stringBitmask, dayOfWeek.getValue() - 1)) {
        daysOfWeek.add(dayOfWeek);
      }
    }

    return Optional.of(Collections.unmodifiableSet(daysOfWeek));
  }

  private static boolean getBit(String bitmask, int position) {
    return bitmask.charAt(position) == '1';
  }
}
