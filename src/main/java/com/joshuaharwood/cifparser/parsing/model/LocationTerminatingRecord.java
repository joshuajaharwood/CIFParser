package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.LocationTerminatingFields;
import java.util.List;

public record LocationTerminatingRecord(String location) implements
    LocationRecord<LocationTerminatingFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TERMINATING_LOCATION;
  }

  @Override
  public List<LocationTerminatingFields> fields() {
    return List.of(LocationTerminatingFields.values());
  }
}
