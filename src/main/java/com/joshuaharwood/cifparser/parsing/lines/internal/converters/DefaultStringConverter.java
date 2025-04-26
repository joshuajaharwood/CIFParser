package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

public class DefaultStringConverter implements Converter<String> {

  private static final DefaultStringConverter INSTANCE = new DefaultStringConverter();

  public static DefaultStringConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public String apply(String input) {
    if (input.isBlank()) {
      throw new IllegalArgumentException("Given String must not be blank.");
    }

    return input.trim();
  }
}
