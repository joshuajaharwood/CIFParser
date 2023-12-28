package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.LocationOriginFields;

import java.time.LocalTime;

public record LocationOriginRecord(String location, LocalTime scheduledDepartureTime,
                                   LocalTime publicDepartureTime, String platform, String line,
                                   String engineeringAllowance, String pathingAllowance,
                                   String activity, String performanceAllowance,
                                   String spare) implements LocationRecord<LocationOriginFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ORIGIN_LOCATION;
  }

}
