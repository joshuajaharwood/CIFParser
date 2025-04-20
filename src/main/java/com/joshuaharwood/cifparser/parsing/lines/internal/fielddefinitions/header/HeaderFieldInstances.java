package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class HeaderFieldInstances {

  public static final HeaderScheduleField<RecordIdentity> RECORD_IDENTITY = new RecordIdentityField();
  public static final HeaderScheduleField<String> FILE_MAINFRAME_IDENTITY = new FileMainframeIdentityField();
  public static final HeaderScheduleField<LocalDate> DATE_OF_EXTRACT = new DateOfExtractField();
  public static final HeaderScheduleField<LocalTime> TIME_OF_EXTRACT = new TimeOfExtractField();
  public static final HeaderScheduleField<String> CURRENT_FILE_REFERENCE = new CurrentFileReferenceField();
  public static final HeaderScheduleField<String> LAST_FILE_REFERENCE = new LastFileReferenceField();
  public static final HeaderScheduleField<UpdateIndicator> UPDATE_INDICATOR = new UpdateIndicatorField();
  public static final HeaderScheduleField<Character> VERSION = new VersionField();
  public static final HeaderScheduleField<LocalDate> USER_START_DATE = new UserStartDateField();
  public static final HeaderScheduleField<LocalDate> USER_END_DATE = new UserEndDateField();
  public static final HeaderScheduleField<String> SPARE = new SpareField();
  private static final List<HeaderScheduleField<?>> ALL_INSTANCES = ImmutableList.of(RECORD_IDENTITY,
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

  private HeaderFieldInstances() {
  }

  public static List<HeaderScheduleField<?>> getAll() {
    return ALL_INSTANCES;
  }
}