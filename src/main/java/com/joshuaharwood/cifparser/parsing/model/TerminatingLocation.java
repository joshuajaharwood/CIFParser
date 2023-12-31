package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TerminatingLocationFields;

public record TerminatingLocation(String location) implements
    LocationRecord<TerminatingLocationFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TERMINATING_LOCATION;
  }

}
