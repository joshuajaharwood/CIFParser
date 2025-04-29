package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate.IntermediateLocationField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.IntermediateLocation;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public final class IntermediateLocationParser implements
  RecordSpecificParser<IntermediateLocation> {

  private final IntermediateLocationRowDefinition fieldDefinitions;

  public IntermediateLocationParser() {
    this(IntermediateLocationRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public IntermediateLocationParser(IntermediateLocationRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public IntermediateLocation parse(String record) {
    return new IntermediateLocation(fieldDefinitions.location().substringAndConvert(record),
      fieldDefinitions.scheduledArrivalTime().substringAndConvert(record),
      fieldDefinitions.scheduledDepartureTime().substringAndConvert(record),
      fieldDefinitions.scheduledPass().substringAndConvert(record),
      fieldDefinitions.publicArrival().substringAndConvert(record),
      fieldDefinitions.publicDeparture().substringAndConvert(record),
      fieldDefinitions.platform().substringAndConvert(record),
      fieldDefinitions.line().substringAndConvert(record),
      fieldDefinitions.path().substringAndConvert(record),
      fieldDefinitions.activity().substringAndConvert(record),
      fieldDefinitions.engineeringAllowance().substringAndConvert(record),
      fieldDefinitions.pathingAllowance().substringAndConvert(record),
      fieldDefinitions.performanceAllowance().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record IntermediateLocationRowDefinition(RowField<String> location,
                                                  RowField<LocalTime> scheduledArrivalTime,
                                                  RowField<LocalTime> scheduledDepartureTime,
                                                  RowField<LocalTime> scheduledPass,
                                                  RowField<LocalTime> publicArrival,
                                                  RowField<LocalTime> publicDeparture,
                                                  RowField<String> platform, RowField<String> line,
                                                  RowField<String> path, RowField<String> activity,
                                                  RowField<String> engineeringAllowance,
                                                  RowField<String> pathingAllowance,
                                                  RowField<String> performanceAllowance,
                                                  RowField<@Nullable String> spare) {

    public static final IntermediateLocationRowDefinition DEFAULT_ROW_DEFINITION = new IntermediateLocationRowDefinition(
      Instances.LOCATION,
      Instances.SCHEDULED_ARRIVAL_TIME,
      Instances.SCHEDULED_DEPARTURE_TIME,
      Instances.SCHEDULED_PASS,
      Instances.PUBLIC_ARRIVAL,
      Instances.PUBLIC_DEPARTURE,
      Instances.PLATFORM,
      Instances.LINE,
      Instances.PATH,
      Instances.ACTIVITY,
      Instances.ENGINEERING_ALLOWANCE,
      Instances.PATHING_ALLOWANCE,
      Instances.PERFORMANCE_ALLOWANCE,
      Instances.SPARE);
  }
}
