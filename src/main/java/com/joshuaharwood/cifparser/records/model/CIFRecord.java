package com.joshuaharwood.cifparser.records.model;

public sealed interface CIFRecord permits AssociationRecord, HeaderRecord, TiplocRecord {

  RecordIdentity recordIdentity();

  String spare();
}
