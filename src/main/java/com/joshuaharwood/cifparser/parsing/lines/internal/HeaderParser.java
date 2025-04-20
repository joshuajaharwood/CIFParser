package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.model.Header;

public final class HeaderParser implements RecordSpecificParser<Header> {

  public Header parse(String record) {
//    final Map<HeaderFields, String> parsedValues = StringParser.parse(record,
//        HeaderFields.values());
//
//    return new Header(ifPresent(parsedValues.get(HeaderFields.FILE_IDENTITY)).orElseThrow(() -> new RequiredPropertyMissingException(
//        HeaderFields.FILE_IDENTITY.name(),
//      parsedValues)),
//        DateConverter.apply(parsedValues.get(HeaderFields.DATE_OF_EXTRACT)).orElse(null),
//        TimeConverter.apply(parsedValues.get(HeaderFields.TIME_OF_EXTRACT)).orElse(null),
//        ifPresent(parsedValues.get(HeaderFields.CURRENT_FILE_REFERENCE)).orElseThrow(() -> new RequiredPropertyMissingException(
//            HeaderFields.CURRENT_FILE_REFERENCE.name(),
//          parsedValues)),
//        ifPresent(parsedValues.get(HeaderFields.LAST_FILE_REFERENCE)).orElse(null),
//        LiteralLookup.lookup(UpdateIndicator.class, parsedValues.get(HeaderFields.UPDATE_INDICATOR))
//                     .orElse(null),
//        ifPresent(parsedValues.get(HeaderFields.VERSION)).map(this::parseChar).orElse(null),
//        DateConverter.apply(parsedValues.get(HeaderFields.EXTRACT_START_DATE)).orElse(null),
//        DateConverter.apply(parsedValues.get(HeaderFields.EXTRACT_END_DATE)).orElse(null),
//        ifPresent(parsedValues.get(HeaderFields.SPARE)).orElse(null));
  }
}
