package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicscheduleextended.BasicScheduleExtendedField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.Nullable;

public final class BasicScheduleExtendedParser implements
  RecordSpecificParser<BasicScheduleExtended> {

  private final BasicScheduleExtendedRowDefinition fieldDefinitions;

  public BasicScheduleExtendedParser() {
    this(BasicScheduleExtendedRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public BasicScheduleExtendedParser(BasicScheduleExtendedRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public BasicScheduleExtended parse(String record) {
    return new BasicScheduleExtended(fieldDefinitions.tractionClass().substringAndConvert(record),
      fieldDefinitions.uicCode().substringAndConvert(record),
      fieldDefinitions.atocCode().substringAndConvert(record),
      fieldDefinitions.applicableTimetableCode().substringAndConvert(record),
      fieldDefinitions.rsid().substringAndConvert(record),
      fieldDefinitions.dataSource().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record BasicScheduleExtendedRowDefinition(RowField<RecordIdentity> recordIdentity,
                                                   RowField<@Nullable String> tractionClass,
                                                   RowField<String> uicCode,
                                                   RowField<String> atocCode,
                                                   RowField<ApplicableTimetableCode> applicableTimetableCode,
                                                   RowField<String> rsid,
                                                   RowField<Character> dataSource,
                                                   RowField<@Nullable String> spare) {

    public static final BasicScheduleExtendedRowDefinition DEFAULT_ROW_DEFINITION = new BasicScheduleExtendedRowDefinition(
      Instances.RECORD_IDENTITY,
      Instances.TRACTION_CLASS,
      Instances.UIC_CODE,
      Instances.ATOC_CODE,
      Instances.APPLICABLE_TIMETABLE_CODE,
      Instances.RETAIL_SERVICE_ID,
      Instances.SOURCE,
      Instances.SPARE);
  }
}
