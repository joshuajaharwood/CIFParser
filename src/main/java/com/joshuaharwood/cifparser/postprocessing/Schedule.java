package com.joshuaharwood.cifparser.postprocessing;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.lines.model.LocationRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Schedule(BasicSchedule basicSchedule, BasicScheduleExtended basicScheduleExtended,
                       Route route) {

  @Contract("_ -> new")
  public @NotNull Schedule withBasicSchedule(BasicSchedule basicSchedule) {
    return new Schedule(basicSchedule, basicScheduleExtended, route);
  }

  @Contract("_ -> new")
  public @NotNull Schedule withBasicScheduleExtended(BasicScheduleExtended basicScheduleExtended) {
    return new Schedule(basicSchedule, basicScheduleExtended, route);
  }

  @Contract("_ -> new")
  public @NotNull Schedule withRoute(Route route) {
    return new Schedule(basicSchedule, basicScheduleExtended, route);
  }

  public record Route(OriginLocation originLocation, List<LocationRecord> nonTerminalPoints,
                      TerminatingLocation terminatingLocation) {

    public Route withOriginLocation(OriginLocation originLocation) {
      return new Route(originLocation, nonTerminalPoints, terminatingLocation);
    }

    public Route withTerminatingLocation(TerminatingLocation terminatingLocation) {
      return new Route(originLocation, nonTerminalPoints, terminatingLocation);
    }

  }
}
