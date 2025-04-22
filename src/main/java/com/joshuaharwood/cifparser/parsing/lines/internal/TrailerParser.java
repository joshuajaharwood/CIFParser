package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.Converter.convert;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer.RecordIdentityField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer.SpareField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer.TrailerField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer.TrailerField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.Trailer;

public final class TrailerParser implements RecordSpecificParser<Trailer> {

  @Override
  public Trailer parse(String record) {
    var builder = new Trailer.Builder();

    for (TrailerField<?> trailerField : Instances.getAll()) {
      switch (trailerField) {
        case RecordIdentityField _ -> {
        }
        case SpareField spareField -> builder.setSpare(convert(spareField, record));
      }
    }

    return builder.createTrailer();
  }
}
