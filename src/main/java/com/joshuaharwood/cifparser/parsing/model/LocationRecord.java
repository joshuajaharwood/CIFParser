package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;

public sealed interface LocationRecord<T extends RowField> extends CIFRecord<T> permits
    LocationOriginRecord {
  String location();
}
