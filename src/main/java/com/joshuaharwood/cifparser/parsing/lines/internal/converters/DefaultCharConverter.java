package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

public class DefaultCharConverter implements Converter<Character> {

  private static final DefaultCharConverter INSTANCE = new DefaultCharConverter();

  private DefaultCharConverter() {
  }

  public static DefaultCharConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public Character apply(String input) {
    if (input.length() > 1) {
      throw new IllegalArgumentException("Multiple characters passed to %s. [Input: %s]".formatted(
        DefaultCharConverter.class.getSimpleName(),
        input));
    }

    if (input.isBlank()) {
      throw new IllegalArgumentException("Empty string passed to %s.".formatted(
        DefaultCharConverter.class.getSimpleName()));
    }

    return input.charAt(0);
  }
}
