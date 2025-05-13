package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public record IntermediateLocation(
  String location,
  @Nullable LocalTime scheduledArrivalTime,
  @Nullable LocalTime scheduledDepartureTime,
  @Nullable LocalTime scheduledPass,
  @Nullable LocalTime publicArrival,
  @Nullable LocalTime publicDeparture,
  @Nullable String platform,
  @Nullable String line,
  @Nullable String path,
  @Nullable String activity,
  @Nullable String engineeringAllowance,
  @Nullable String pathingAllowance,
  @Nullable String performanceAllowance,
  @Nullable String spare
) implements
  LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.INTERMEDIATE_LOCATION;
  }

}
