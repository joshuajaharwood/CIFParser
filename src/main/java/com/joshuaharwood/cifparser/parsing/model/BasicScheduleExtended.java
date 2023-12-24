package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.ApplicableTimetableCode;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.enums.Toc;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.BasicScheduleExtendedFields;
import java.util.List;

public record BasicScheduleExtended(String tractionClass, String uicCode, Toc atocCode,
                                    ApplicableTimetableCode applicableTimetableCode, String rsid,
                                    Character dataSource) implements
    CIFRecord<BasicScheduleExtendedFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE_EXTRA_DETAILS;
  }

  @Override
  public List<BasicScheduleExtendedFields> fields() {
    return List.of(BasicScheduleExtendedFields.values());
  }


}
