package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public record BasicScheduleExtended(String tractionClass, Integer uicCode, String atocCode,
                                    ApplicableTimetableCode applicableTimetableCode, String rsid,
                                    Character dataSource, String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE_EXTRA_DETAILS;
  }
}
