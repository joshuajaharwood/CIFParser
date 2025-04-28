package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import org.jspecify.annotations.Nullable;

public record BasicScheduleExtended(@Nullable String tractionClass, String uicCode,
                                    String atocCode,
                                    ApplicableTimetableCode applicableTimetableCode, String rsid,
                                    Character dataSource, @Nullable String spare) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE_EXTRA_DETAILS;
  }
}
