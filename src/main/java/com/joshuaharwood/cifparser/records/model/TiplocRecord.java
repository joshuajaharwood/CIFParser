package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.fielddefinitions.RowField;

public sealed interface TiplocRecord<T extends RowField> extends CIFRecord<T> permits
    TiplocAmendRecord, TiplocDeleteRecord, TiplocInsertRecord {

  String tiploc();
}
