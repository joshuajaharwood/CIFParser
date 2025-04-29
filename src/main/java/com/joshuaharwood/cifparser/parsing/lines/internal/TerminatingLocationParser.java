package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating.TerminatingLocationField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
import java.time.LocalTime;
import org.jspecify.annotations.Nullable;

public final class TerminatingLocationParser implements RecordSpecificParser<TerminatingLocation> {

  private final TerminatingLocationRowDefinition fieldDefinitions;

  public TerminatingLocationParser() {
    this(TerminatingLocationRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public TerminatingLocationParser(TerminatingLocationRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public TerminatingLocation parse(String record) {
    return new TerminatingLocation(fieldDefinitions.location().substringAndConvert(record),
      fieldDefinitions.scheduledArrivalTime().substringAndConvert(record),
      fieldDefinitions.publicArrivalTime().substringAndConvert(record),
      fieldDefinitions.platform().substringAndConvert(record),
      fieldDefinitions.path().substringAndConvert(record),
      fieldDefinitions.activity().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record TerminatingLocationRowDefinition(RowField<String> location,
                                                 RowField<LocalTime> scheduledArrivalTime,
                                                 RowField<LocalTime> publicArrivalTime,
                                                 RowField<String> platform, RowField<String> path,
                                                 RowField<String> activity,
                                                 RowField<@Nullable String> spare) {

    public static final TerminatingLocationRowDefinition DEFAULT_ROW_DEFINITION = new TerminatingLocationRowDefinition(
      Instances.LOCATION,
      Instances.SCHEDULED_ARRIVAL_TIME,
      Instances.PUBLIC_ARRIVAL_TIME,
      Instances.PLATFORM,
      Instances.PATH,
      Instances.ACTIVITY,
      Instances.SPARE);

  }
}
