package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.fielddefinitions.RowField;
import java.util.List;

public sealed interface CIFRecord<T extends RowField> permits AssociationRecord, BasicSchedule,
    BasicScheduleExtended, HeaderRecord, LocationRecord, TiplocRecord, TrailerRecord {

  RecordIdentity recordIdentity();

  List<T> fields();
}
