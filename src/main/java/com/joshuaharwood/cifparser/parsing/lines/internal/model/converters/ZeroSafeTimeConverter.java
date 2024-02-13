package com.joshuaharwood.cifparser.parsing.lines.internal.model.converters;

import java.time.LocalTime;
import java.util.Optional;

public class ZeroSafeTimeConverter {

  private ZeroSafeTimeConverter() {
  }

  public static Optional<LocalTime> convert(String input) {
    if (input == null) {
      return Optional.empty();
    }

    if (input.trim().equals("0000")) {
      return Optional.empty();
    }

    return TimeConverter.convert(input);
  }
}
