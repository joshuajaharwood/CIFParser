package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;

public sealed interface LocationRecord<T extends RowField> extends CIFRecord permits
    ChangeEnRouteRecord, LocationIntermediateRecord, LocationOriginRecord,
    LocationTerminatingRecord {

  String location();
}
