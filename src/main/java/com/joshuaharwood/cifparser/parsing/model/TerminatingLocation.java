package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TerminatingLocationFields;
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
