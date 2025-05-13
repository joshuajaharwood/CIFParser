package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public record TerminatingLocation(String location,
                                  LocalTime scheduledArrivalTime,
                                  LocalTime publicArrivalTime,
                                  String platform,
                                  @Nullable String path,
                                  String activity,
                                  @Nullable String spare) implements
  LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TERMINATING_LOCATION;
  }

}
