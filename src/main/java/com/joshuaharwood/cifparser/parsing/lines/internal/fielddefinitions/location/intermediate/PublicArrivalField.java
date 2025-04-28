package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public non-sealed class PublicArrivalField implements
  IntermediateLocationField<LocalTime> {

  private static final ZeroSafeTimeConverter CONVERTER = ZeroSafeTimeConverter.getInstance();

  PublicArrivalField() {
  }

  @Override
  public int startIndex() {
    return 25;
  }

  @Override
  public String name() {
    return "PUBLIC_ARRIVAL";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  // TODO: how should we separate null-possible and null-impossible converters in the annotation library's opinion?
  @SuppressWarnings("NullableProblems")
  @Override
  @Nullable
  public LocalTime convert(String raw) {
    return CONVERTER.apply(raw).orElse(null);
  }


  @Override
  public String toString() {
    return "PublicArrivalField[]";
  }

}