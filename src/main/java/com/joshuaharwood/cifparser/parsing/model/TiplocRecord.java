package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;

public sealed interface TiplocRecord<T extends RowField> extends CIFRecord permits
    TiplocAmendRecord, TiplocDeleteRecord, TiplocInsertRecord {

  String tiploc();
}