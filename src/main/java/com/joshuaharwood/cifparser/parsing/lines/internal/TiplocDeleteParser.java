package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.delete.TiplocDeleteField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocDelete;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.Nullable;

public final class TiplocDeleteParser implements RecordSpecificParser<TiplocDelete> {

  private final TiplocDeleteRowDefinition fieldDefinitions;

  public TiplocDeleteParser() {
    this(TiplocDeleteRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public TiplocDeleteParser(TiplocDeleteRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public TiplocDelete parse(String record) {
    return new TiplocDelete(TiplocDeleteRowDefinition.DEFAULT_ROW_DEFINITION.tiploc()
      .substringAndConvert(record),
      TiplocDeleteRowDefinition.DEFAULT_ROW_DEFINITION.spare().substringAndConvert(record));
  }

  public record TiplocDeleteRowDefinition(RowField<RecordIdentity> recordIdentity,
                                          RowField<String> tiploc,
                                          RowField<@Nullable String> spare) {

    public static final TiplocDeleteRowDefinition DEFAULT_ROW_DEFINITION = new TiplocDeleteRowDefinition(
      Instances.RECORD_IDENTITY,
      Instances.TIPLOC_CODE,
      Instances.SPARE);
  }
}