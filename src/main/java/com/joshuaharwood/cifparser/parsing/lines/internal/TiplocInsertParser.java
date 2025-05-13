package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert.TiplocInsertField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocInsert;
import org.jspecify.annotations.Nullable;

public final class TiplocInsertParser implements RecordSpecificParser<TiplocInsert> {

  private final TiplocInsertRowDefinition fieldDefinitions;

  public TiplocInsertParser() {
    this(TiplocInsertRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public TiplocInsertParser(TiplocInsertRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public TiplocInsert parse(String record) {
    return new TiplocInsert(fieldDefinitions.tiplocCode().substringAndConvert(record),
      // Fixme: not sure this one's right...
      fieldDefinitions.capitalsIdentification().substringAndConvert(record),
      fieldDefinitions.nlc().substringAndConvert(record),
      fieldDefinitions.nlcCheckCharacter().substringAndConvert(record),
      fieldDefinitions.tpsDescription().substringAndConvert(record),
      fieldDefinitions.stanox().substringAndConvert(record),
      fieldDefinitions.poMcpCode().substringAndConvert(record),
      fieldDefinitions.threeAlphaCode().substringAndConvert(record),
      fieldDefinitions.nlcDescription().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record TiplocInsertRowDefinition(RowField<String> tiplocCode,
                                          RowField<Byte> capitalsIdentification,
                                          RowField<String> nlc,
                                          RowField<Character> nlcCheckCharacter,
                                          RowField<String> tpsDescription, 
                                          RowField<String> stanox,
                                          RowField<String> poMcpCode,
                                          RowField<String> threeAlphaCode,
                                          RowField<String> nlcDescription,
                                          RowField<@Nullable String> spare) {

    public static final TiplocInsertRowDefinition DEFAULT_ROW_DEFINITION = new TiplocInsertRowDefinition(
      Instances.TIPLOC_CODE,
      Instances.CAPITALS,
      Instances.NATIONAL_LOCATION_CODE,
      Instances.NLC_CHECK_CHARACTER,
      Instances.TPS_DESCRIPTION,
      Instances.STANOX,
      Instances.PO_MCP_CODE,
      Instances.THREE_ALPHA_FIELD,
      Instances.DESCRIPTION,
      Instances.SPARE);
  }
}
