package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface LocationRecord<T extends RowField> extends CifRecord permits
    ChangeEnRoute, IntermediateLocation, OriginLocation,
    TerminatingLocation {

  String location();
}
