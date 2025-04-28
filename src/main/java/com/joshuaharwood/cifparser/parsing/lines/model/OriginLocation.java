package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalTime;

public record OriginLocation(String location, LocalTime scheduledDepartureTime,
                             LocalTime publicDepartureTime, String platform, String line,
                             String engineeringAllowance, String pathingAllowance,
                             String activity, String performanceAllowance,
                             String spare) implements LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ORIGIN_LOCATION;
  }

}
