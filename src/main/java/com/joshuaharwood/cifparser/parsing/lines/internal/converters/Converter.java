package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.util.function.Function;

@FunctionalInterface
public interface Converter<R> extends Function<String, R> {

  R apply(String input);
}
