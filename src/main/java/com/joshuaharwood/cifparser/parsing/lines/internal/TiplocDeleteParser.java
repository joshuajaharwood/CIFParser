package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocDelete;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.TiplocDeleteFields;
import java.util.Map;

public final class TiplocDeleteParser implements RecordSpecificParser<TiplocDelete> {

  @Override
  public TiplocDelete parse(String record) {
    final Map<TiplocDeleteFields, String> parsedValues = StringParser.parse(record,
        TiplocDeleteFields.values());

    return new TiplocDelete(ifPresent(parsedValues.get(TiplocDeleteFields.TIPLOC_CODE)).orElseThrow(
        () -> new RequiredPropertyMissingException(TiplocDeleteFields.TIPLOC_CODE.name(),
          parsedValues)), ifPresent(parsedValues.get(TiplocDeleteFields.SPARE)).orElse(null));
  }
}
