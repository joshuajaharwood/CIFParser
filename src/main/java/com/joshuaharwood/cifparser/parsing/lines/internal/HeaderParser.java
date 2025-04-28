package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.HeaderField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public final class HeaderParser implements RecordSpecificParser<Header> {

  private final HeaderRowDefinition fieldDefinitions;

  public HeaderParser() {
    this(HeaderRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public HeaderParser(HeaderRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  public Header parse(String record) {
    return new Header(fieldDefinitions.fileMainframeIdentity().substringAndConvert(record),
      fieldDefinitions.dateOfExtract().substringAndConvert(record),
      fieldDefinitions.timeOfExtract().substringAndConvert(record),
      fieldDefinitions.currentFileReference().substringAndConvert(record),
      fieldDefinitions.lastFileReference().substringAndConvert(record),
      fieldDefinitions.updateIndicator().substringAndConvert(record),
      fieldDefinitions.version().substringAndConvert(record),
      fieldDefinitions.userStartDate().substringAndConvert(record),
      fieldDefinitions.userEndDate().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record HeaderRowDefinition(RowField<RecordIdentity> recordIdentity,
                                    RowField<String> fileMainframeIdentity,
                                    RowField<LocalDate> dateOfExtract,
                                    RowField<LocalTime> timeOfExtract,
                                    RowField<String> currentFileReference,
                                    RowField<String> lastFileReference,
                                    RowField<UpdateIndicator> updateIndicator,
                                    RowField<Character> version, RowField<LocalDate> userStartDate,
                                    RowField<LocalDate> userEndDate,
                                    RowField<@Nullable String> spare) {

    public static final HeaderRowDefinition DEFAULT_ROW_DEFINITION = new HeaderRowDefinition(
      Instances.RECORD_IDENTITY,
      Instances.FILE_MAINFRAME_IDENTITY,
      Instances.DATE_OF_EXTRACT,
      Instances.TIME_OF_EXTRACT,
      Instances.CURRENT_FILE_REFERENCE,
      Instances.LAST_FILE_REFERENCE,
      Instances.UPDATE_INDICATOR,
      Instances.VERSION,
      Instances.USER_START_DATE,
      Instances.USER_END_DATE,
      Instances.SPARE);
  }
}
