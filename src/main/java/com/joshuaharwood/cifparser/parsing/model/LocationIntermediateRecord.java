package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.LocationIntermediateFields;
import java.time.LocalTime;

public record LocationIntermediateRecord(String location, LocalTime scheduledArrivalTime,
                                         LocalTime scheduledDepartureTime, LocalTime scheduledPass,
                                         LocalTime publicArrival, LocalTime publicDeparture,
                                         String platform, String line, String path, String activity,
                                         String engineeringAllowance, String pathingAllowance,
                                         String performanceAllowance, String spare) implements
    LocationRecord<LocationIntermediateFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.INTERMEDIATE_LOCATION;
  }

}
