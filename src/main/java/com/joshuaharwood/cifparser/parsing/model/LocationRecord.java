package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;

public sealed interface LocationRecord<T extends RowField> extends CifRecord permits
    ChangeEnRoute, IntermediateLocation, OriginLocation,
    TerminatingLocation {

  String location();
}
