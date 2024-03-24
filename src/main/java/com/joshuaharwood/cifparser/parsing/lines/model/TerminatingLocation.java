package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;

public record TerminatingLocation(String location,
                                  LocalTime scheduledArrivalTime,
                                  LocalTime publicArrivalTime,
                                  String platform,
                                  String path,
                                  String activity,
                                  String spare) implements
    LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TERMINATING_LOCATION;
  }

}
