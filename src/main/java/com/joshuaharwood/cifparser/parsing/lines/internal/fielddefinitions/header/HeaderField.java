package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;

public sealed interface HeaderField<T> extends RowField<T> permits
  CurrentFileReferenceField, DateOfExtractField, FileMainframeIdentityField, LastFileReferenceField,
  RecordIdentityField, SpareField, TimeOfExtractField, UpdateIndicatorField, UserEndDateField,
  UserStartDateField, VersionField {

  class Instances {
  
    public static final HeaderField<RecordIdentity> RECORD_IDENTITY = new RecordIdentityField();
    public static final HeaderField<String> FILE_MAINFRAME_IDENTITY = new FileMainframeIdentityField();
    public static final HeaderField<LocalDate> DATE_OF_EXTRACT = new DateOfExtractField();
    public static final HeaderField<LocalTime> TIME_OF_EXTRACT = new TimeOfExtractField();
    public static final HeaderField<String> CURRENT_FILE_REFERENCE = new CurrentFileReferenceField();
    public static final HeaderField<String> LAST_FILE_REFERENCE = new LastFileReferenceField();
    public static final HeaderField<UpdateIndicator> UPDATE_INDICATOR = new UpdateIndicatorField();
    public static final HeaderField<Character> VERSION = new VersionField();
    public static final HeaderField<LocalDate> USER_START_DATE = new UserStartDateField();
    public static final HeaderField<LocalDate> USER_END_DATE = new UserEndDateField();
    public static final HeaderField<String> SPARE = new SpareField();
    private static final ImmutableList<HeaderField<?>> ALL_INSTANCES = ImmutableList.of(RECORD_IDENTITY,
      FILE_MAINFRAME_IDENTITY,
      DATE_OF_EXTRACT,
      TIME_OF_EXTRACT,
      CURRENT_FILE_REFERENCE,
      LAST_FILE_REFERENCE,
      UPDATE_INDICATOR,
      VERSION,
      USER_START_DATE,
      USER_END_DATE,
      SPARE);
  
    private Instances() {
    }
  
    public static ImmutableList<HeaderField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}
