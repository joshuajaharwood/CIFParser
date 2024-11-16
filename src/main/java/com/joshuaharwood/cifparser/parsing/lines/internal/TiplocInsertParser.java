package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.TiplocInsertFields;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocInsert;
import java.util.Map;

public final class TiplocInsertParser implements RecordSpecificParser<TiplocInsert> {

  @Override
  public TiplocInsert parse(String record) {
    final Map<TiplocInsertFields, String> parsedValues = StringParser.parse(record,
      TiplocInsertFields.values());

    return new TiplocInsert(
      ifPresent(parsedValues.get(TiplocInsertFields.TIPLOC_CODE)).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.CAPITALS)).map(Byte::parseByte).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.NATIONAL_LOCATION_CODE)).orElse(null),
      parseChar(parsedValues.get(TiplocInsertFields.NLC_CHECK_CHARACTER)),
      ifPresent(parsedValues.get(TiplocInsertFields.TPS_DESCRIPTION)).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.STANOX)).map(Integer::valueOf).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.PO_MCP_CODE)).map(Integer::valueOf)
        .orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.CRS_CODE)).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.DESCRIPTION)).orElse(null),
      ifPresent(parsedValues.get(TiplocInsertFields.SPARE)).orElse(null));
  }
}
