package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;

public record ReservationsField() implements ChangeEnRouteField<Reservations> {

  private static final LiteralConverter<Reservations> CONVERTER = LiteralConverter.create(
    Reservations.class);

  @Override
  public int startIndex() {
    return 48;
  }

  @Override
  public String name() {
    return "RESERVATIONS";
  }

  @Override
  public int length() {
    return 1;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Reservations convert(String raw) {
    return CONVERTER.apply(raw);
  }
}