package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TrailerField<T> extends RowField<T> permits RecordIdentityField,
  SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final SpareField SPARE = new SpareField();

    private Instances() {
    }
  }
}