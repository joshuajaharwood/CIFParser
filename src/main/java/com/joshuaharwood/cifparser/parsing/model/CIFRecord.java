package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public sealed interface CIFRecord permits AssociationRecord, BasicSchedule, BasicScheduleExtended,
    HeaderRecord, LocationRecord, TiplocRecord, TrailerRecord {

  RecordIdentity recordIdentity();
}
