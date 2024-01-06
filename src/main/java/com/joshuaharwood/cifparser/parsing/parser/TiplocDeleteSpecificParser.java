package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.TiplocDelete;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TiplocDeleteFields;
import java.util.Map;

public final class TiplocDeleteSpecificParser implements RecordSpecificParser<TiplocDelete> {

  @Override
  public TiplocDelete parse(String record) {
    final Map<TiplocDeleteFields, String> parsedValues = StringParser.parse(record,
        TiplocDeleteFields.values());

    return new TiplocDelete(ifPresent(parsedValues.get(TiplocDeleteFields.TIPLOC_CODE)).orElseThrow(
        () -> new RequiredPropertyMissingException(TiplocDeleteFields.TIPLOC_CODE.getName(),
            record,
            parsedValues)), ifPresent(parsedValues.get(TiplocDeleteFields.SPARE)).orElse(null));
  }
}
