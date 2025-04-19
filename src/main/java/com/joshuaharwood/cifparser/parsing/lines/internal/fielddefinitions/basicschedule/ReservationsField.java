package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import static com.joshuaharwood.cifparser.parsing.lines.internal.converters.Converters.RESERVATIONS_CONVERTER;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import java.util.function.Function;

public record ReservationsField() implements BasicScheduleField<Reservations> {

  @Override
  public int order() {
    return 21;
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
  public Function<String, Reservations> converter() {
    return RESERVATIONS_CONVERTER;
  }
}
