package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.enums.Toc;

public record BasicScheduleExtended(String tractionClass, String uicCode, Toc atocCode,
                                    ApplicableTimetableCode applicableTimetableCode, String rsid,
                                    Character dataSource) implements CIFRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE_EXTRA_DETAILS;
  }
}