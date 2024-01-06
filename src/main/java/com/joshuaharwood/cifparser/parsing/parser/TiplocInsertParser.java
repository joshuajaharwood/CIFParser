package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.TiplocInsert;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TiplocAmendFields;
import java.util.Map;

public final class TiplocInsertParser implements RecordParser<TiplocInsert> {

  @Override
  public TiplocInsert parse(String record) {
    final Map<TiplocAmendFields, String> parsedValues = StringParser.parse(record,
        TiplocAmendFields.values());

    return new TiplocInsert(ifPresent(parsedValues.get(TiplocAmendFields.TIPLOC)).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.CAPITALS)).map(Byte::parseByte).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.NATIONAL_LOCATION_CODE)).map(Integer::valueOf)
                                                                             .orElse(null),
        parseChar(parsedValues.get(TiplocAmendFields.NLC_CHECK_CHARACTER)),
        ifPresent(parsedValues.get(TiplocAmendFields.TPS_DESCRIPTION)).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.STANOX)).map(Integer::valueOf).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.PO_MCP_CODE)).map(Integer::valueOf)
                                                                  .orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.CRS_CODE)).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.DESCRIPTION)).orElse(null),
        ifPresent(parsedValues.get(TiplocAmendFields.SPARE)).orElse(null));
  }
}
