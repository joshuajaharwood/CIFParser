package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;

public record BasicScheduleExtended(String tractionClass, Integer uicCode, String atocCode,
                                    ApplicableTimetableCode applicableTimetableCode, String rsid,
                                    Character dataSource, String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE_EXTRA_DETAILS;
  }
}
