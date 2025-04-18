package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class DaysOfWeekBitmaskConverter implements Converter<Set<DayOfWeek>> {

  private static final DaysOfWeekBitmaskConverter INSTANCE = new DaysOfWeekBitmaskConverter();

  private DaysOfWeekBitmaskConverter() {
  }

  public static DaysOfWeekBitmaskConverter getInstance() {
    return INSTANCE;
  }

  private static boolean getBit(String bitmask, int position) {
    char c = bitmask.charAt(position);

    if (c != '1' && c != '0') {
      throw new IllegalArgumentException("Illegal character in bitmask. [Bitmask: %s] [Index: %d]".formatted(
        bitmask,
        position));
    }

    return c == '1';
  }

  /**
   * Converts days-of-the-week bitmasks to {@link Set}s representing the days the bitmask
   * represents.
   *
   * @param stringBitmask A 7-digit bitmask where the left-most digit represents Monday, and the
   *                      right-most digit Sunday. A zero is false, and a one is true.
   * @return A {@link Set} of {@link DayOfWeek}s where the day of the week is true in the bitmask if
   * the character is 1, or false otherwise.
   * @throws NullPointerException     if {@code stringBitmask} is {@code null}.
   * @throws IllegalArgumentException if {@code stringBitmask} is longer or shorter than 7
   *                                  characters.
   */
  public Set<DayOfWeek> apply(String stringBitmask) {
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

    return Collections.unmodifiableSet(daysOfWeek);
  }
}
