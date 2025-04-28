package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend.TiplocAmendField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocAmend;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.Nullable;

public final class TiplocAmendParser implements RecordSpecificParser<TiplocAmend> {

  private final TiplocAmendRowDefinition fieldDefinitions;

  public TiplocAmendParser() {
    this(TiplocAmendRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public TiplocAmendParser(TiplocAmendRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public TiplocAmend parse(String record) {
    return new TiplocAmend(fieldDefinitions.tiplocCode().substringAndConvert(record),
      fieldDefinitions.capitalsIdentification().substringAndConvert(record),
      fieldDefinitions.nlc().substringAndConvert(record),
      fieldDefinitions.nlcCheckCharacter().substringAndConvert(record),
      fieldDefinitions.tpsDescription().substringAndConvert(record),
      fieldDefinitions.stanox().substringAndConvert(record),
      fieldDefinitions.poMcpCode().substringAndConvert(record),
      fieldDefinitions.threeAlphaCode().substringAndConvert(record),
      fieldDefinitions.nlcDescription().substringAndConvert(record),
      fieldDefinitions.newTiploc().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record));
  }

  public record TiplocAmendRowDefinition(RowField<RecordIdentity> recordIdentity,
                                         RowField<String> tiplocCode,
                                         RowField<Byte> capitalsIdentification,
                                         RowField<String> nlc,
                                         RowField<Character> nlcCheckCharacter,
                                         RowField<String> tpsDescription,
                                         RowField<String> stanox,
                                         RowField<String> poMcpCode,
                                         RowField<String> threeAlphaCode,
                                         RowField<String> nlcDescription,
                                         RowField<String> newTiploc,
                                         RowField<@Nullable String> spare) {

    public static final TiplocAmendRowDefinition DEFAULT_ROW_DEFINITION = new TiplocAmendRowDefinition(
      Instances.RECORD_IDENTITY_FIELD,
      Instances.TIPLOC_CODE_FIELD,
      Instances.CAPITALS_IDENTIFICATION_FIELD,
      Instances.NLC_FIELD,
      Instances.NLC_CHECK_CHARACTER_FIELD,
      Instances.TPS_DESCRIPTION_FIELD,
      Instances.STANOX_FIELD,
      Instances.PO_MCP_CODE_FIELD,
      Instances.THREE_ALPHA_CODE_FIELD,
      Instances.NLC_DESCRIPTION_FIELD,
      Instances.NEW_TIPLOC_FIELD,
      Instances.SPARE_FIELD);
  }
}