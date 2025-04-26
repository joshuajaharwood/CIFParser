package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.intermediate;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface IntermediateLocationField<T> extends RowField<T> permits
  RecordIdentityField, LocationField, ScheduledArrivalTimeField, ScheduledDepartureTimeField,
  ScheduledPassField, PublicArrivalField, PublicDepartureField, PlatformField, LineField,
  PathField, ActivityField, EngineeringAllowanceField, PathingAllowanceField,
  PerformanceAllowanceField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final LocationField LOCATION = new LocationField();
    public static final ScheduledArrivalTimeField SCHEDULED_ARRIVAL_TIME = new ScheduledArrivalTimeField();
    public static final ScheduledDepartureTimeField SCHEDULED_DEPARTURE_TIME = new ScheduledDepartureTimeField();
    public static final ScheduledPassField SCHEDULED_PASS = new ScheduledPassField();
    public static final PublicArrivalField PUBLIC_ARRIVAL = new PublicArrivalField();
    public static final PublicDepartureField PUBLIC_DEPARTURE = new PublicDepartureField();
    public static final PlatformField PLATFORM = new PlatformField();
    public static final LineField LINE = new LineField();
    public static final PathField PATH = new PathField();
    public static final ActivityField ACTIVITY = new ActivityField();
    public static final EngineeringAllowanceField ENGINEERING_ALLOWANCE = new EngineeringAllowanceField();
    public static final PathingAllowanceField PATHING_ALLOWANCE = new PathingAllowanceField();
    public static final PerformanceAllowanceField PERFORMANCE_ALLOWANCE = new PerformanceAllowanceField();
    public static final SpareField SPARE = new SpareField();

    private static final ImmutableList<IntermediateLocationField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      LOCATION,
      SCHEDULED_ARRIVAL_TIME,
      SCHEDULED_DEPARTURE_TIME,
      SCHEDULED_PASS,
      PUBLIC_ARRIVAL,
      PUBLIC_DEPARTURE,
      PLATFORM,
      LINE,
      PATH,
      ACTIVITY,
      ENGINEERING_ALLOWANCE,
      PATHING_ALLOWANCE,
      PERFORMANCE_ALLOWANCE,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<IntermediateLocationField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}