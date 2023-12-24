package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.LocationOriginFields;

import java.util.List;

//TODO: Fill me in!
public record LocationOriginRecord(String location ) implements LocationRecord<LocationOriginFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ORIGIN_LOCATION;
  }

  @Override
  public List<LocationOriginFields> fields() {
    return List.of(LocationOriginFields.values());
  }

  @Override
  public String location() {
    return location;
  }
}
