package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.lines.model.exceptions.RequiredPropertyMissingException;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.BasicScheduleExtendedFields;
import java.util.Map;

public final class BasicScheduleExtendedParser implements
    RecordSpecificParser<BasicScheduleExtended> {

  @Override
  public BasicScheduleExtended parse(String record) {
    final Map<BasicScheduleExtendedFields, String> parsedValues = StringParser.parse(record,
        BasicScheduleExtendedFields.values());

    return new BasicScheduleExtended(ifPresent(parsedValues.get(BasicScheduleExtendedFields.TRACTION_CLASS)).orElse(
        null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.UIC_CODE))
            .map(Integer::valueOf)
            .orElse(null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.ATOC_CODE)).orElseThrow(() -> new RequiredPropertyMissingException(
            BasicScheduleExtendedFields.ATOC_CODE.name(),
          parsedValues)),
        lookup(ApplicableTimetableCode.class,
            parsedValues.get(BasicScheduleExtendedFields.APPLICABLE_TIMETABLE_CODE)).orElseThrow(() -> new RequiredPropertyMissingException(
            BasicScheduleExtendedFields.APPLICABLE_TIMETABLE_CODE.name(),
          parsedValues)),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.RETAIL_SERVICE_ID)).orElse(null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.SOURCE))
            .map(this::parseChar)
            .orElse(null),
        ifPresent(parsedValues.get(BasicScheduleExtendedFields.SPARE)).orElse(null));
  }
}
