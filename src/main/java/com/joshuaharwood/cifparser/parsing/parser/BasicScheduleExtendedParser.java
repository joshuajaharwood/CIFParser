package com.joshuaharwood.cifparser.parsing.parser;

import static com.joshuaharwood.cifparser.parsing.model.literals.LiteralLookup.lookup;

import com.joshuaharwood.cifparser.parsing.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.model.enums.Toc;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.BasicScheduleExtendedFields;
import java.util.Map;

public final class BasicScheduleExtendedParser implements RecordParser<BasicScheduleExtended> {

  @Override
  public BasicScheduleExtended parse(String record) {
    final Map<BasicScheduleExtendedFields, String> parsedValues = StringParser.parse(record,
        BasicScheduleExtendedFields.values());

    return new BasicScheduleExtended(ifPresent(parsedValues.get(BasicScheduleExtendedFields.TRACTION_CLASS)).orElse(
        null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.UIC_CODE))
            .map(Integer::valueOf)
            .orElse(null),
        lookup(Toc.class,
            parsedValues.get(BasicScheduleExtendedFields.ATOC_CODE)).orElseThrow(() -> new RequiredPropertyMissingException(
            BasicScheduleExtendedFields.ATOC_CODE.getName(),
            record,
            parsedValues)),
        lookup(ApplicableTimetableCode.class,
            parsedValues.get(BasicScheduleExtendedFields.APPLICABLE_TIMETABLE_CODE)).orElseThrow(() -> new RequiredPropertyMissingException(
            BasicScheduleExtendedFields.APPLICABLE_TIMETABLE_CODE.getName(),
            record,
            parsedValues)),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.RETAIL_SERVICE_ID)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.SOURCE))
            .map(this::parseChar)
            .orElse(null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.SPARE)).orElse(null));
  }
}
