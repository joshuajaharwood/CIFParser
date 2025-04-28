package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer.TrailerField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.Trailer;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.Nullable;

public final class TrailerParser implements RecordSpecificParser<Trailer> {

  private final TrailerRowDefinition fieldDefinitions;

  public TrailerParser() {
    this(TrailerRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public TrailerParser(TrailerRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public Trailer parse(String record) {
    return new Trailer(fieldDefinitions.spare().substringAndConvert(record));
  }

  public record TrailerRowDefinition(RowField<RecordIdentity> recordIdentity,
                                     RowField<@Nullable String> spare) {

    public static final TrailerRowDefinition DEFAULT_ROW_DEFINITION = new TrailerRowDefinition(
      Instances.RECORD_IDENTITY,
      Instances.SPARE);
  }
}
