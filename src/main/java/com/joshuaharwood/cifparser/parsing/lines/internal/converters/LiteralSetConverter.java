package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.primitives.Chars;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Literal;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.DuplicateLiteralException;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.UnknownLiteralException;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public class LiteralSetConverter<T extends Enum<T> & Literal> implements Converter<Set<T>> {

  private final Class<T> literalClass;

  private final Set<T> viableLiteralSet;

  private LiteralSetConverter(Class<T> literalClass) {
    this.literalClass = literalClass;
    this.viableLiteralSet = EnumSet.allOf(literalClass)
      .stream()
      .filter(t -> t.getLiteral() != null)
      .collect(Sets.toImmutableEnumSet());
  }

  public static <T extends Enum<T> & Literal> LiteralSetConverter<T> getInstance(Class<T> clazz) {
    return new LiteralSetConverter<>(clazz);
  }

  @SuppressWarnings("DataFlowIssue")
  @Override
  @NonNull
  public Set<T> apply(String input) {
    if (input.isBlank()) {
      return ImmutableSet.of();
    }

    List<Character> chars = Chars.asList(input.trim().toUpperCase().toCharArray());

    EnumSet<T> foundSet = EnumSet.noneOf(literalClass);

    
    //TODO: can we optimise this further?
    for (Character c : chars) {
      var found = viableLiteralSet.stream()
        .filter(t -> Objects.equals(t.getLiteral().charAt(0), c))
        .toList();

      if (found.isEmpty()) {
        throw new UnknownLiteralException(literalClass, input);
      }

      if (found.size() > 1) {
        throw new DuplicateLiteralException(literalClass, input, found);
      }

      foundSet.add(found.getFirst());
    }

    return Sets.immutableEnumSet(foundSet);
  }
}