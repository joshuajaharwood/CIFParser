package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.origin;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface OriginLocationField<T> extends RowField<T> permits
  RecordIdentityField, LocationField, ScheduledDepartureTimeField, PublicDepartureTimeField,
  PlatformField, LineField, EngineeringAllowanceField, PathingAllowanceField,
  ActivityField, PerformanceAllowanceField, SpareField {

  class Instances {
    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final LocationField LOCATION = new LocationField();
    public static final ScheduledDepartureTimeField SCHEDULED_DEPARTURE_TIME = new ScheduledDepartureTimeField();
    public static final PublicDepartureTimeField PUBLIC_DEPARTURE_TIME = new PublicDepartureTimeField();
    public static final PlatformField PLATFORM = new PlatformField();
    public static final LineField LINE = new LineField();
    public static final EngineeringAllowanceField ENGINEERING_ALLOWANCE = new EngineeringAllowanceField();
    public static final PathingAllowanceField PATHING_ALLOWANCE = new PathingAllowanceField();
    public static final ActivityField ACTIVITY = new ActivityField();
    public static final PerformanceAllowanceField PERFORMANCE_ALLOWANCE = new PerformanceAllowanceField();
    public static final SpareField SPARE = new SpareField();

    private static final ImmutableList<OriginLocationField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      LOCATION,
      SCHEDULED_DEPARTURE_TIME,
      PUBLIC_DEPARTURE_TIME,
      PLATFORM,
      LINE,
      ENGINEERING_ALLOWANCE,
      PATHING_ALLOWANCE,
      ACTIVITY,
      PERFORMANCE_ALLOWANCE,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<OriginLocationField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}