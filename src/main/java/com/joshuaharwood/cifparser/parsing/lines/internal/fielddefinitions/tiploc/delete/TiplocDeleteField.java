package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.delete;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TiplocDeleteField<T> extends RowField<T> permits
  RecordIdentityField, TiplocCodeField, SpareField {

  class Instances {
    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TiplocCodeField TIPLOC_CODE = new TiplocCodeField();
    public static final SpareField SPARE = new SpareField();

    private static final ImmutableList<TiplocDeleteField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      TIPLOC_CODE,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<TiplocDeleteField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}