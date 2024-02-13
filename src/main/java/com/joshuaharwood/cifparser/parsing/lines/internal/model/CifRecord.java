package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;

public sealed interface CifRecord permits Association, BasicSchedule, BasicScheduleExtended,
    Header, LocationRecord, TiplocRecord, Trailer {

  RecordIdentity recordIdentity();
}
