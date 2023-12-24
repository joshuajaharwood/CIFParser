package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.RowField;
import java.util.List;

public sealed interface CIFRecord<T extends RowField> permits AssociationRecord, BasicSchedule,
    BasicScheduleExtended, HeaderRecord, LocationRecord, TiplocRecord, TrailerRecord {

  RecordIdentity recordIdentity();

  List<T> fields();
}
