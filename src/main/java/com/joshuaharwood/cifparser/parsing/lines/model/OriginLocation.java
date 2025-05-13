package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public record OriginLocation(
  String location,
  LocalTime scheduledDepartureTime,
  @Nullable LocalTime publicDepartureTime,
  String platform,
  String line,
  @Nullable String engineeringAllowance,
  @Nullable String pathingAllowance,
  String activity,
  @Nullable String performanceAllowance,
  @Nullable String spare
) implements LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ORIGIN_LOCATION;
  }

}
