package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

public class NoopConverter implements Converter<String> {

  private static final NoopConverter INSTANCE = new NoopConverter();

  private NoopConverter() {
  }
  
  public static NoopConverter getInstance() {
    return INSTANCE;
  }

  @Override
  public String apply(String input) {
    return input;
  }
}
