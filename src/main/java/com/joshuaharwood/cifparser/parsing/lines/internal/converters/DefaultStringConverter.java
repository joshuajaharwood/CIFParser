package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import org.jspecify.annotations.Nullable;

public class DefaultStringConverter implements Converter<String> {

  private static final DefaultStringConverter INSTANCE = new DefaultStringConverter();

  public static DefaultStringConverter getInstance() {
    return INSTANCE;
  }

  @Override
  @Nullable
  public String apply(String input) {
    if (input.isBlank()) {
      return null;
    }

    return input.trim();
  }
}
