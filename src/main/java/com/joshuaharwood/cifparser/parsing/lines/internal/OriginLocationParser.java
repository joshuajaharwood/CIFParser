package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin.OriginLocationField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
import java.time.LocalTime;

public final class OriginLocationParser implements RecordSpecificParser<OriginLocation> {

  private final OriginLocationRowDefinition fieldDefinitions;

  public OriginLocationParser() {
    this(OriginLocationRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public OriginLocationParser(OriginLocationRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public OriginLocation parse(String record) {
    return new OriginLocation(fieldDefinitions.location().substringAndConvert(record),
      fieldDefinitions.scheduledDepartureTime().substringAndConvert(record),
      fieldDefinitions.publicDepartureTime().substringAndConvert(record),
      fieldDefinitions.platform().substringAndConvert(record),
      fieldDefinitions.line().substringAndConvert(record),
      fieldDefinitions.engineeringAllowance().substringAndConvert(record),
      fieldDefinitions.pathingAllowance().substringAndConvert(record),
      fieldDefinitions.activity().substringAndConvert(record),
      fieldDefinitions.performanceAllowance().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record OriginLocationRowDefinition(RowField<String> location,
                                            RowField<LocalTime> scheduledDepartureTime,
                                            RowField<LocalTime> publicDepartureTime,
                                            RowField<String> platform, RowField<String> line,
                                            RowField<String> engineeringAllowance,
                                            RowField<String> pathingAllowance,
                                            RowField<String> activity,
                                            RowField<String> performanceAllowance,
                                            RowField<String> spare) {

    public static final OriginLocationRowDefinition DEFAULT_ROW_DEFINITION = new OriginLocationRowDefinition(
      Instances.LOCATION,
      Instances.SCHEDULED_DEPARTURE_TIME,
      Instances.PUBLIC_DEPARTURE_TIME,
      Instances.PLATFORM,
      Instances.LINE,
      Instances.ENGINEERING_ALLOWANCE,
      Instances.PATHING_ALLOWANCE,
      Instances.ACTIVITY,
      Instances.PERFORMANCE_ALLOWANCE,
      Instances.SPARE);
  }

}
