package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface BasicScheduleExtendedField<T> extends RowField<T> permits
  RecordIdentityField, TractionClassField, UicCodeField, AtocCodeField,
  ApplicableTimetableCodeField, RetailServiceIdField, SourceField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TractionClassField TRACTION_CLASS = new TractionClassField();
    public static final UicCodeField UIC_CODE = new UicCodeField();
    public static final AtocCodeField ATOC_CODE = new AtocCodeField();
    public static final ApplicableTimetableCodeField APPLICABLE_TIMETABLE_CODE = new ApplicableTimetableCodeField();
    public static final RetailServiceIdField RETAIL_SERVICE_ID = new RetailServiceIdField();
    public static final SourceField SOURCE = new SourceField();
    public static final SpareField SPARE = new SpareField();
    private static final ImmutableList<BasicScheduleExtendedField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      TRACTION_CLASS,
      UIC_CODE,
      ATOC_CODE,
      APPLICABLE_TIMETABLE_CODE,
      RETAIL_SERVICE_ID,
      SOURCE,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<BasicScheduleExtendedField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}