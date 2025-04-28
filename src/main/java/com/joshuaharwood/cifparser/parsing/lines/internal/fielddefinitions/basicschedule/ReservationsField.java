package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;

public non-sealed class ReservationsField implements BasicScheduleField<Reservations> {

  private static final LiteralConverter<Reservations> CONVERTER = LiteralConverter.create(
    Reservations.class);

  ReservationsField() {
  }

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
    return CONVERTER.apply(raw);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj != null && obj.getClass() == this.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "ReservationsField[]";
  }

}
