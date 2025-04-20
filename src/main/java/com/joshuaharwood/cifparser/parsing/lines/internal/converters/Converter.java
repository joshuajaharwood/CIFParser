package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import java.util.function.Function;
import org.jspecify.annotations.NullUnmarked;

//TODO: review this interface contract's nullability
@NullUnmarked
@FunctionalInterface
public interface Converter<R> extends Function<String, R> {

  R apply(String input);
}
