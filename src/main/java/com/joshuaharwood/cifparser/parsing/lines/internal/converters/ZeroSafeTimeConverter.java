package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.time.LocalTime;
import java.util.Optional;

public class ZeroSafeTimeConverter implements Converter<Optional<LocalTime>> {

  private static final ZeroSafeTimeConverter INSTANCE = new ZeroSafeTimeConverter();

  private static final TimeConverter TIME_CONVERTER = TimeConverter.getInstance();

  private ZeroSafeTimeConverter() {
  }

  public static ZeroSafeTimeConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public Optional<LocalTime> apply(String input) {
    if (input.trim().equals("0000")) {
      return Optional.empty();
    }

    return Optional.of(TIME_CONVERTER.apply(input));
  }
}
