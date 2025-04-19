package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

@FunctionalInterface
public interface Converter<R> extends Function<String, R> {

  @Nullable
  R apply(String input);
}
