package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;


public sealed interface TrailerField<T> extends RowField<T> permits RecordIdentityField,
  SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final SpareField SPARE = new SpareField();
    private static final ImmutableList<TrailerField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<TrailerField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}