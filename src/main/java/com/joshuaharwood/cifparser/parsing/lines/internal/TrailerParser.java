package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.Trailer;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.fielddefinitions.TrailerFields;
import java.util.Map;

public final class TrailerParser implements RecordSpecificParser<Trailer> {

  @Override
  public Trailer parse(String record) {
    final Map<TrailerFields, String> parsedValues = StringParser.parse(record,
        TrailerFields.values());

    return new Trailer(parsedValues.get(TrailerFields.SPARE));
  }
}
