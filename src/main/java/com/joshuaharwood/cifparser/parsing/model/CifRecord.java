package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public sealed interface CifRecord permits Association, BasicSchedule, BasicScheduleExtended,
    Header, LocationRecord, TiplocRecord, Trailer {

  RecordIdentity recordIdentity();
}
