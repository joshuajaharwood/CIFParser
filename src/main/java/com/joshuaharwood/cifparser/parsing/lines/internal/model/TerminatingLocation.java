package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.fielddefinitions.TerminatingLocationFields;
import java.time.LocalTime;

public record TerminatingLocation(String location,
                                  LocalTime scheduledArrivalTime,
                                  LocalTime publicArrivalTime,
                                  String platform,
                                  String path,
                                  String activity,
                                  String spare) implements
    LocationRecord<TerminatingLocationFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TERMINATING_LOCATION;
  }

}
