package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;

public sealed interface CIFRecord permits AssociationRecord, BasicSchedule, BasicScheduleExtended,
    HeaderRecord, TiplocRecord {

  RecordIdentity recordIdentity();
}
