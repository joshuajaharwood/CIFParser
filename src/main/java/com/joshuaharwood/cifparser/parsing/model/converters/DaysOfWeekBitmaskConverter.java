package com.joshuaharwood.cifparser.parsing.model.converters;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class DaysOfWeekBitmaskConverter {

  public static Map<DayOfWeek, Boolean> convert(String stringBitmask) {
    if (stringBitmask.length() != 7) {
      throw new IllegalArgumentException("days-of-week bitmask must be 7 binary digits.");
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

    return Collections.unmodifiableMap(daysOfWeek);
  }

  private static boolean getBit(int bits, int position) {
    return (bits & (1L << position)) != 0;
  }
}
