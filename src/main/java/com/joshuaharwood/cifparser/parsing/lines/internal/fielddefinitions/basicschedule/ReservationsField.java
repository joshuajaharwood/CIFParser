package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;

public record ReservationsField() implements BasicScheduleField<Reservations> {
  @Override
  public int startIndex() {
    return 68;
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
    return LiteralConverter.create(Reservations.class).apply(raw);
  }
}
