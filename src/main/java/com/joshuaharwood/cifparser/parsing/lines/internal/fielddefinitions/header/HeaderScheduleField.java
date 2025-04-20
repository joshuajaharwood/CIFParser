package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface HeaderScheduleField<T> extends RowField<T> permits
  CurrentFileReferenceField, DateOfExtractField, FileMainframeIdentityField, LastFileReferenceField,
  RecordIdentityField, SpareField, TimeOfExtractField, UpdateIndicatorField, UserEndDateField,
  UserStartDateField, VersionField {
}
