package com.joshuaharwood.cifparser.parsing.model.fielddefinitions;

public sealed interface RowField permits AssociationRowFields, BasicScheduleExtendedFields,
    BasicScheduleFields, ChangesEnRouteFields, HeaderFields, LocationIntermediateFields,
    LocationOriginFields, LocationTerminatingFields, TiplocAmendFields, TiplocDeleteFields,
    TiplocInsertFields, TrailerFields {

  int getOrder();

  String getName();

  int getLength();
}
