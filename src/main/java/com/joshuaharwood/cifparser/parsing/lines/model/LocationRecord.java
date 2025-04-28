package com.joshuaharwood.cifparser.parsing.lines.model;

public sealed interface LocationRecord extends CifRecord permits
  ChangeEnRoute, IntermediateLocation, OriginLocation,
  TerminatingLocation {

  String location();
}
