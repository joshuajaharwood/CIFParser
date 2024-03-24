package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;

public record IntermediateLocation(String location, LocalTime scheduledArrivalTime,
                                   LocalTime scheduledDepartureTime, LocalTime scheduledPass,
                                   LocalTime publicArrival, LocalTime publicDeparture,
                                   String platform, String line, String path, String activity,
                                   String engineeringAllowance, String pathingAllowance,
                                   String performanceAllowance, String spare) implements
    LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.INTERMEDIATE_LOCATION;
  }

}
