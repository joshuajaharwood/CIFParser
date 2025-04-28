package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.delete;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TiplocDeleteField<T> extends RowField<T> permits RecordIdentityField,
  TiplocCodeField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TiplocCodeField TIPLOC_CODE = new TiplocCodeField();
    public static final SpareField SPARE = new SpareField();

    private Instances() {
    }
  }
}