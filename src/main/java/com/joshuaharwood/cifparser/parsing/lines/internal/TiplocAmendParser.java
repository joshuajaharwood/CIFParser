package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.Converter.convert;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend.TiplocAmendField;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocAmend;

public final class TiplocAmendParser implements RecordSpecificParser<TiplocAmend> {

  @Override
  public TiplocAmend parse(String record) {
    return new TiplocAmend(
      convert(TiplocAmendField.Instances.CAPITALS_IDENTIFICATION_FIELD, record),
      convert(TiplocAmendField.Instances.NLC_FIELD, record),
      convert(TiplocAmendField.Instances.NLC_CHECK_CHARACTER_FIELD, record),
      convert(TiplocAmendField.Instances.TPS_DESCRIPTION_FIELD, record),
      convert(TiplocAmendField.Instances.STANOX_FIELD, record),
      convert(TiplocAmendField.Instances.PO_MCP_CODE_FIELD, record),
      convert(TiplocAmendField.Instances.THREE_ALPHA_CODE_FIELD, record),
      convert(TiplocAmendField.Instances.NLC_DESCRIPTION_FIELD, record),
      convert(TiplocAmendField.Instances.NEW_TIPLOC_FIELD, record),
      convert(TiplocAmendField.Instances.SPARE_FIELD, record)
    );
  }
}