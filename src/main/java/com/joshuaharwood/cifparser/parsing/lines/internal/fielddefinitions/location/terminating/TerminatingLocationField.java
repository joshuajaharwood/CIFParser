package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.terminating;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TerminatingLocationField<T> extends RowField<T> permits RecordIdentityField,
  LocationField, ScheduledArrivalTimeField, PublicArrivalTimeField, PlatformField, PathField,
  ActivityField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final LocationField LOCATION = new LocationField();
    public static final ScheduledArrivalTimeField SCHEDULED_ARRIVAL_TIME = new ScheduledArrivalTimeField();
    public static final PublicArrivalTimeField PUBLIC_ARRIVAL_TIME = new PublicArrivalTimeField();
    public static final PlatformField PLATFORM = new PlatformField();
    public static final PathField PATH = new PathField();
    public static final ActivityField ACTIVITY = new ActivityField();
    public static final SpareField SPARE = new SpareField();

    private Instances() {
    }
  }
}