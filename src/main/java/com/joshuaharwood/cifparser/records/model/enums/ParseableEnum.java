package com.joshuaharwood.cifparser.records.model.enums;

import java.util.Optional;

public interface ParseableEnum<T extends Enum<T>> {
  Optional<T> parse(char c);
  Optional<T> parse(String s);
}
