package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import org.jspecify.annotations.Nullable;

public class DefaultCharConverter implements Converter<Character> {

  private static final DefaultCharConverter INSTANCE = new DefaultCharConverter();

  public static DefaultCharConverter getInstance() {
    return INSTANCE;
  }

  @Override
  @Nullable
  public Character apply(String input) {
    if (input.length() > 1) {
      throw new IllegalArgumentException("Multiple characters passed to %s. [Input: %s]".formatted(
        DefaultCharConverter.class.getSimpleName(),
        input));
    }
    
    if (input.isEmpty()) {
      throw new IllegalArgumentException("Empty string passed to %s.".formatted(
        DefaultCharConverter.class.getSimpleName()));
    }

    char c = input.charAt(0);

    if (Character.isWhitespace(c)) {
      return null;
    }

    return c;
  }
}
