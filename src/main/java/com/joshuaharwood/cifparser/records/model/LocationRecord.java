package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.fielddefinitions.RowField;

public sealed interface LocationRecord<T extends RowField> extends CIFRecord<T> permits
    LocationOriginRecord {
  String location();
}
