package com.joshuaharwood.cifparser.records.model;

public sealed interface CIFRecord permits HeaderRecord, TiplocRecord {
  RecordIdentity recordIdentity();
  String spare();
}
