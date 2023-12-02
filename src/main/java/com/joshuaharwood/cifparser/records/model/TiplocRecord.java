package com.joshuaharwood.cifparser.records.model;

public sealed interface TiplocRecord extends CIFRecord permits TiplocDeleteRecord,
    TiplocInsertRecord {

  String tiploc();
}
