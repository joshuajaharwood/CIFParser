package com.joshuaharwood.cifparser.parsing.parser;

import com.joshuaharwood.cifparser.parsing.model.Trailer;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TrailerFields;
import java.util.Map;

public final class TrailerParser implements RecordParser<Trailer> {

  @Override
  public Trailer parse(String record) {
    final Map<TrailerFields, String> parsedValues = StringParser.parse(record,
        TrailerFields.values());

    return new Trailer(parsedValues.get(TrailerFields.SPARE));
  }
}
